package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun apply(actionButton: Button, titleTextView: TextView, progressBar: ProgressBar)

    class Loading : UiState {

        override fun apply(
            actionButton: Button,
            titleTextView: TextView,
            progressBar: ProgressBar,
        ) {
            actionButton.isEnabled = false
            titleTextView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }

    class Loaded : UiState {

        override fun apply(
            actionButton: Button,
            titleTextView: TextView,
            progressBar: ProgressBar,
        ) {
            progressBar.visibility = View.GONE
            titleTextView.visibility = View.VISIBLE
            actionButton.isEnabled = true
        }
    }
}
