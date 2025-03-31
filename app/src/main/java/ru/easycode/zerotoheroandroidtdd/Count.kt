package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState
    fun increment(number: String): UiState
    fun decrement(number: String): UiState

    class Base(private val step: Int, private val max: Int, private val min: Int) : Count {

        init {
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
            if (max < 1) throw IllegalStateException("max should be positive, but was $max")
            if (max < step) throw IllegalStateException("max should be more than step")
            if (max < min) throw IllegalStateException("max should be more than min")
        }

        override fun initial(number: String): UiState {
            val numeric = number.toInt()
            if (numeric == min || numeric - step < min) return UiState.Min(numeric.toString())
            return if (numeric + step > max || numeric == max) UiState.Max(numeric.toString())
            else UiState.Base(numeric.toString())
        }

        override fun increment(number: String): UiState {
            val numeric = number.toInt() + step
            if (numeric > max) return UiState.Max(number)
            return if (numeric + step > max || numeric == max) UiState.Max(numeric.toString())
            else UiState.Base(numeric.toString())
        }

        override fun decrement(number: String): UiState {
            val numeric = number.toInt() - step
            if (numeric < min) return UiState.Min(number)
            return if (numeric == min || numeric - step < min) UiState.Min(numeric.toString())
            else UiState.Base(numeric.toString())
        }
    }
}