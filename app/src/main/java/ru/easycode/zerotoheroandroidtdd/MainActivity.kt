package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var incrementButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countTextView = findViewById<TextView>(R.id.countTextView)
        incrementButton = findViewById<Button>(R.id.incrementButton)
        val count: Count = Count.Base(2, 4)

        incrementButton?.setOnClickListener {
            val result = count.increment(countTextView.text.toString())
            countTextView.text = result.toString()
            if (result == UiState.Max(countTextView.text.toString())) {
                incrementButton?.isEnabled = false
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        incrementButton?.let { outState.putBoolean(KEY, it.isEnabled) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        incrementButton?.isEnabled = savedInstanceState.getBoolean(KEY)
    }

    companion object {
        private const val KEY = "key"
    }

}