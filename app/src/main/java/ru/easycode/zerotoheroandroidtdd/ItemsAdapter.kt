package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import ru.easycode.zerotoheroandroidtdd.databinding.ItemLayoutBinding

class ItemsAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private val itemsList = ArrayList<CharSequence>()

    fun add(source: CharSequence) {
        itemsList.add(source)
        notifyItemInserted(itemsList.size - 1)
    }

    fun save(bundle: Bundle) {
        bundle.putCharSequenceArrayList(KEY, itemsList)
    }

    fun restore(bundle: Bundle) {
        itemsList.addAll(bundle.getCharSequenceArrayList(KEY) ?: ArrayList())
        notifyItemRangeInserted(0, itemsList.size)
    }

    companion object {
        private const val KEY = "ItemAdapterKey"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemLayoutBinding
                .inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size
}

class ItemViewHolder(private val binding: ItemLayoutBinding) : ViewHolder(binding.root) {

    fun bind(source: CharSequence) {
        binding.elementTextView.text = source
    }
}