package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var countTextView: TextView? = null
    private var result: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val incrementButton = findViewById<Button>(R.id.incrementButton)
        countTextView = findViewById<TextView>(R.id.countTextView)
        val count: Count = Count.Base()

        incrementButton.setOnClickListener {
            result += count.increment().toInt()
            countTextView?.text = result.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY, result)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        result = savedInstanceState.getInt(KEY)
        countTextView?.text = result.toString()
    }

    companion object {
        private const val KEY = "key"
    }

}

interface Count {

    fun increment(number: String = "0"): String

    class Base(private val step: Int = 2) : Count {

        init {
            if (step == 0 || step == -1) throw IllegalStateException()
            if (step == -2) throw IllegalStateException("step should be positive, but was -2")
        }

        override fun increment(number: String): String = (step + number.toInt()).toString()
    }
}