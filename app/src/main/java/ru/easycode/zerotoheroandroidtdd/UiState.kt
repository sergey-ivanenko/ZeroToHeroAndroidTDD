package ru.easycode.zerotoheroandroidtdd

import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import java.io.Serializable

interface UiState : Serializable {

    fun apply(titleTextView: TextView, inputEditText: TextInputEditText)

    data class ShowData(private val text: String) : UiState {

        override fun apply(titleTextView: TextView, inputEditText: TextInputEditText) {
            titleTextView.text = text
            inputEditText.setText("")
        }
    }
}