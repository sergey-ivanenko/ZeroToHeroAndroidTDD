package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val actionButton = findViewById<Button>(R.id.actionButton)

        actionButton?.setOnClickListener {
            titleTextView?.visibility = View.INVISIBLE
            it.isEnabled = false
            progressBar.visibility = View.VISIBLE
            actionButton.postDelayed({
                titleTextView.visibility = View.VISIBLE
                progressBar.visibility = View.INVISIBLE
                it.isEnabled = true
            }, 3500)
        }
    }
}