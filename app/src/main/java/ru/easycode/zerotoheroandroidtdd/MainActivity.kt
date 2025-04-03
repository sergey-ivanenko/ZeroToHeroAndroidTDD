package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as App).viewModel

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val dataTextView = findViewById<TextView>(R.id.titleTextView)
        val actionButton = findViewById<Button>(R.id.actionButton)

        actionButton.setOnClickListener {
            viewModel.load()
        }

        viewModel.liveData().observe(this) { uiState ->
            uiState.apply(progressBar, dataTextView, actionButton)
        }
    }
}