package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val count: Count = Count.Base()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val countTextView = findViewById<TextView>(R.id.countTextView)

        incrementButton.setOnClickListener {
            val result = count.increment(countTextView?.text.toString())
            countTextView?.text = result.toString()
        }
    }
}