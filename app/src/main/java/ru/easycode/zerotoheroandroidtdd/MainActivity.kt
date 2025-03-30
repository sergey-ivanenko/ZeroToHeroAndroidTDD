package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var uiState: UiState = UiState.Base("0")
    private val count: Count = Count.Base(2, 4)
    private var countTextView: TextView? = null
    private var incrementButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countTextView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)

        incrementButton?.setOnClickListener {
            uiState = count.increment(countTextView?.text.toString())
            uiState.apply(countTextView, incrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        else
            savedInstanceState.getSerializable(KEY) as UiState

        uiState.apply(countTextView, incrementButton)
    }

    companion object {
        private const val KEY = "key"
    }
}