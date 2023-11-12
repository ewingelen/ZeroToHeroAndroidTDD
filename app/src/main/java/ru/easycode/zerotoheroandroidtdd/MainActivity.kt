package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionButton = findViewById<Button>(R.id.actionButton)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        var uiState: UiState

        actionButton.setOnClickListener {
            uiState = UiState.Loading()
            uiState.apply(actionButton, titleTextView, progressBar)

            Handler(Looper.getMainLooper()).postDelayed({
                uiState = UiState.Loaded()
                uiState.apply(actionButton, titleTextView, progressBar)
            }, 500)
        }
    }
}
