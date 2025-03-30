package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {

        init {
            if(step < 1) throw IllegalStateException("step should be positive, but was $step")
            if (max < 1) throw IllegalStateException("max should be positive, but was $max")
            if(step > max) throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val numeric = step + number.toInt()
            if (numeric > max) return UiState.Max(number)
            return if(numeric == max || numeric + step > max) UiState.Max(numeric.toString())
            else UiState.Base(numeric.toString())
        }
    }
}