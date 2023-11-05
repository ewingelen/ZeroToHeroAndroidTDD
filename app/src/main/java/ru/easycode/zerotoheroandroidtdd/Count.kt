package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState

    fun increment(number: String): UiState

    fun decrement(number: String): UiState

    abstract class Abstract(
        private val step: Int,
        private val max: Int,
        private val min: Int,
    ) : Count {

        override fun initial(number: String): UiState {
            val numberDigit = number.toInt()
            return when {
                numberDigit + step > max -> UiState.Max(number)
                numberDigit - step < min -> UiState.Min(number)
                else -> UiState.Base(number)
            }
        }
    }

    class Base(private val step: Int, max: Int, min: Int) : Abstract(step, max, min) {

        init {
            when {
                step < 1 -> throw IllegalStateException("step should be positive, but was $step")
                max < 1 -> throw IllegalStateException("max should be positive, but was $max")
                max < step -> throw IllegalStateException("max should be more than step")
                max < min -> throw IllegalStateException("max should be more than min")
            }
        }

        override fun increment(number: String): UiState {
            val result = number.toInt().plus(step).toString()
            return super.initial(result)
        }

        override fun decrement(number: String): UiState {
            val result = number.toInt().minus(step).toString()
            return super.initial(result)
        }
    }
}
