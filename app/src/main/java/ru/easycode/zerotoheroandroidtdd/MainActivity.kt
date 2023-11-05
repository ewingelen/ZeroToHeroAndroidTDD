package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var countTextView: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    private lateinit var uiState: UiState
    private val count = Count.Base(step = 2, max = 4, min = 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        countTextView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)

        incrementButton.setOnClickListener {
            uiState = count.increment(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton, decrementButton)
        }

        decrementButton.setOnClickListener {
            uiState = count.decrement(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton, decrementButton)
        }

        if (savedInstanceState == null) {
            uiState = count.initial(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton, decrementButton)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = count.initial(countTextView.text.toString())
        uiState.apply(countTextView, incrementButton, decrementButton)
    }
}
