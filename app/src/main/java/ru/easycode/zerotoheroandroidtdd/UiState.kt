package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(countTextView: TextView, incrementButton: Button, decrementButton: Button)

    abstract class Abstract(private val text: String) : UiState {

        override fun apply(
            countTextView: TextView,
            incrementButton: Button,
            decrementButton: Button,
        ) {
            countTextView.text = text
        }
    }

    data class Base(private val text: String) : Abstract(text) {

        override fun apply(
            countTextView: TextView,
            incrementButton: Button,
            decrementButton: Button,
        ) {
            super.apply(countTextView, incrementButton, decrementButton)
            incrementButton.  isEnabled = true
            decrementButton.isEnabled = true
        }
    }

    data class Max(private val text: String) : Abstract(text) {

        override fun apply(
            countTextView: TextView,
            incrementButton: Button,
            decrementButton: Button,
        ) {
            super.apply(countTextView, incrementButton, decrementButton)
            incrementButton.isEnabled = false
            decrementButton.isEnabled = true
        }
    }

    data class Min(private val text: String) : Abstract(text) {

        override fun apply(
            countTextView: TextView,
            incrementButton: Button,
            decrementButton: Button,
        ) {
            super.apply(countTextView, incrementButton, decrementButton)
            decrementButton.isEnabled = false
            incrementButton.isEnabled = true
        }
    }
}
