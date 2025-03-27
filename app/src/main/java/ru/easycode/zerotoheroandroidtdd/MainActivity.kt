package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private var titleTextView: TextView? = null
    private var removeButton: Button? = null
    private var linearLayout: LinearLayout? = null

    private var state: State = State.Initial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleTextView = findViewById(R.id.titleTextView)
        removeButton = findViewById(R.id.removeButton)
        linearLayout = findViewById(R.id.rootLayout)

        removeButton?.setOnClickListener {
            state = State.NotEnabled
            state.apply(linearLayout, titleTextView, removeButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY) as State
        state.apply(linearLayout, titleTextView, removeButton)
    }

    companion object {
        private const val KEY = "key"
    }
}

interface State : Serializable {

    fun apply(linearLayout: LinearLayout?, textView: TextView?, button: Button?)

    object Initial : State {

        override fun apply(linearLayout: LinearLayout?, textView: TextView?, button: Button?) = Unit
    }

    object NotEnabled : State {

        override fun apply(linearLayout: LinearLayout?, textView: TextView?, button: Button?) {
            linearLayout?.removeView(textView)
            button?.isEnabled = false
        }
    }
}