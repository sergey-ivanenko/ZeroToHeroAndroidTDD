package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(progressBar: ProgressBar, titleTextView: TextView, loadButton: Button)

    data class ShowData(private val text: String) : UiState {

        override fun apply(progressBar: ProgressBar, titleTextView: TextView, loadButton: Button) {
            progressBar.visibility = View.INVISIBLE
            titleTextView.visibility = View.VISIBLE
            titleTextView.text = text
            loadButton.isEnabled = true
        }
    }

    object ShowProgress : UiState {

        override fun apply(progressBar: ProgressBar, titleTextView: TextView, loadButton: Button) {
            progressBar.visibility = View.VISIBLE
            titleTextView.visibility = View.INVISIBLE
            loadButton.isEnabled = false
        }
    }
}