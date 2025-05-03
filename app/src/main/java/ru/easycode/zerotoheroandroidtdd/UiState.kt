package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(progressBar: ProgressBar, titleTextView: TextView, button: Button)

    object ShowProgress : UiState {

        override fun apply(progressBar: ProgressBar, titleTextView: TextView, button: Button) {
            progressBar.visibility = View.VISIBLE
            titleTextView.visibility = View.INVISIBLE
            button.isEnabled = false
        }
    }

    data class ShowData(private val text: String) : UiState {

        override fun apply(progressBar: ProgressBar, titleTextView: TextView, button: Button) {
            progressBar.visibility = View.INVISIBLE
            titleTextView.visibility = View.VISIBLE
            titleTextView.text = text
            button.isEnabled = true
        }
    }
}