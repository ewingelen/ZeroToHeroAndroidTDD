package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun apply(actionButton: Button, progressBar: ProgressBar, titleTextView: TextView)

    object ShowProgress : UiState {

        override fun apply(
            actionButton: Button,
            progressBar: ProgressBar,
            titleTextView: TextView,
        ) {
            actionButton.isEnabled = false
            titleTextView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }

    object ShowData : UiState {

        override fun apply(
            actionButton: Button,
            progressBar: ProgressBar,
            titleTextView: TextView,
        ) {
            progressBar.visibility = View.GONE
            titleTextView.visibility = View.VISIBLE
            actionButton.isEnabled = true
        }
    }
}
