package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var textView: TextView? = null
    var linerLayout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linerLayout = findViewById<LinearLayout>(R.id.rootLayout)
        textView = findViewById<TextView>(R.id.titleTextView)

        val removeButton = findViewById<Button>(R.id.removeButton)
        removeButton.setOnClickListener {
            linerLayout?.removeView(textView)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        linerLayout?.removeView(textView)
    }

    companion object {
        private const val KEY = "key"
    }
}