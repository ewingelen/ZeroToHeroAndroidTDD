package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        val repository: Repository = Repository.Base()
        val liveDataWrapper: LiveDataWrapper = LiveDataWrapper.Base()
        val viewModel = MainViewModel(liveDataWrapper = liveDataWrapper, repository = repository)

        actionButton.setOnClickListener {
            viewModel.load()
        }

        liveDataWrapper.liveData().observe(this) { uiState ->
            uiState.apply(actionButton, titleTextView, progressBar)
        }
    }
}
