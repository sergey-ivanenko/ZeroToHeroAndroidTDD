package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun apply(progressBar: ProgressBar, textView: TextView, button: Button)

    object ShowProgress : UiState {
        override fun apply(progressBar: ProgressBar, textView: TextView, button: Button) {
            progressBar.visibility = View.VISIBLE
            textView.visibility = View.INVISIBLE
            button.isEnabled = false
        }
    }

    object ShowData : UiState {
        override fun apply(progressBar: ProgressBar, textView: TextView, button: Button) {
            progressBar.visibility = View.INVISIBLE
            textView.visibility = View.VISIBLE
            button.isEnabled = true
        }
    }
}