package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var countTextView: TextView
    private lateinit var incrementButton: Button
    private var uiState: UiState = UiState.Base(text = "0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val count = Count.Base(step = 2, max = 4)
        countTextView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        incrementButton.setOnClickListener {
            uiState = count.increment(countTextView.text.toString())
            uiState.apply(countTextView, incrementButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(UI_STATE_KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(UI_STATE_KEY, UiState::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            savedInstanceState.getSerializable(UI_STATE_KEY) as UiState
        }
        uiState.apply(countTextView, incrementButton)
    }

    private companion object {
        const val UI_STATE_KEY = "state"
    }
}
