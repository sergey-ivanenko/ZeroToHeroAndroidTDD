package ru.easycode.zerotoheroandroidtdd

interface UiState {

    class Base(private val text: String) : UiState {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Base

            return text == other.text
        }

        override fun hashCode(): Int {
            return text.hashCode()
        }

        override fun toString(): String = text
    }
    class Max(private val text: String): UiState {

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Max

            return text == other.text
        }

        override fun hashCode(): Int {
            return text.hashCode()
        }

        override fun toString(): String = text
    }
}