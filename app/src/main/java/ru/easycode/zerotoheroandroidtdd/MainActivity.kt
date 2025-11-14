package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val textList = ArrayList<String>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            val inputText = binding.inputEditText.text
            textList.add(inputText.toString())
            val textView = TextView(this).apply {
                text = inputText
            }
            binding.contentLayout.addView(textView)
            binding.inputEditText.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList(KEY, textList)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val list = savedInstanceState.getStringArrayList(KEY) ?: ArrayList<String>()
        textList.addAll(list)
        textList.forEach { inputText ->
            val textView = TextView(this).apply {
                text = inputText
            }
            binding.contentLayout.addView(textView)
        }
    }

    companion object {
        private const val KEY = "list"
    }
}