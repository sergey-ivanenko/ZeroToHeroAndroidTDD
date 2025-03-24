package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.titleTextView)
        if (savedInstanceState != null) {
            textView.text = savedInstanceState.getString("androidText")
        }

        val button = findViewById<Button>(R.id.changeButton)
        button.setOnClickListener {
            textView.text = getString(R.string.android_developer_text)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("androidText", getString(R.string.android_developer_text))
        super.onSaveInstanceState(outState)
    }
}