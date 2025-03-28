package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String = "0"): String

    class Base(private val step: Int = 2) : Count {

        init {
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
        }

        override fun increment(number: String): String = (step + number.toInt()).toString()
    }
}