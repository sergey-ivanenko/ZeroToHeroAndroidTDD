package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var decrementButton: Button? = null
    private var incrementButton: Button? = null
    private var countTextView: TextView? = null

    private var count: Count = Count.Base(step = 2, max = 4, min = 0)
    private var uiState = count.initial("0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decrementButton = findViewById(R.id.decrementButton)
        incrementButton = findViewById(R.id.incrementButton)
        countTextView = findViewById(R.id.countTextView)

        uiState.apply(countTextView, decrementButton, incrementButton)

        decrementButton?.setOnClickListener {
            uiState = count.decrement(countTextView?.text.toString())
            uiState.apply(countTextView, decrementButton, incrementButton)
        }

        incrementButton?.setOnClickListener {
            uiState = count.increment(countTextView?.text.toString())
            uiState.apply(countTextView, decrementButton, incrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(KEY) as UiState
        }
        uiState.apply(countTextView, decrementButton, incrementButton)
    }

    companion object {
        private const val KEY = "iuStateKey"
    }
}