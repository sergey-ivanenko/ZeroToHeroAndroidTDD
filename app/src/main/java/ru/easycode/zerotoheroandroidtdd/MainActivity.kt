package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val inputEditText = findViewById<TextInputEditText>(R.id.inputEditText)
        val actionButton = findViewById<Button>(R.id.actionButton)

        viewModel = (application as App).viewModel
        viewModel?.liveData()?.observe(this) { uiState ->
            uiState.apply(titleTextView, inputEditText)
        }

        actionButton.setOnClickListener {
            viewModel?.load(inputEditText.text.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel?.save(BundleWrapper.Base(outState))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel?.restore(BundleWrapper.Base(savedInstanceState))
    }
}