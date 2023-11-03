package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(countTextView: TextView, incrementButton: Button)

    abstract class Abstract(private val text: String) : UiState {

        override fun apply(countTextView: TextView, incrementButton: Button) {
            countTextView.text = text
        }
    }

    data class Base(private val text: String) : Abstract(text)

    data class Max(private val text: String) : Abstract(text) {

        override fun apply(countTextView: TextView, incrementButton: Button) {
            super.apply(countTextView, incrementButton)
            incrementButton.isEnabled = false
        }
    }
}
