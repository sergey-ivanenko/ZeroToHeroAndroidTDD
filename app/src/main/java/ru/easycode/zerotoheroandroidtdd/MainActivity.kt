package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Runnable

class MainActivity : AppCompatActivity() {

    private var progressBar: ProgressBar? = null
    private var titleTextView: TextView? = null
    private var actionButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressBar = findViewById(R.id.progressBar)
        titleTextView = findViewById(R.id.titleTextView)
        actionButton = findViewById(R.id.actionButton)

        actionButton?.setOnClickListener {
            titleTextView?.visibility = View.INVISIBLE
            it.isEnabled = false
            progressBar?.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                titleTextView?.visibility = View.VISIBLE
                progressBar?.visibility = View.INVISIBLE
                it.isEnabled = true
            }, 3500)
        }
    }
}