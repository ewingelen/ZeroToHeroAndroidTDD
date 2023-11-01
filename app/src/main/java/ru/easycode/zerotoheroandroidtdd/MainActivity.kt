package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var state: State = State.Initial
    private lateinit var rootLayout: LinearLayout
    private lateinit var textView: TextView
    private lateinit var removeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        removeButton = findViewById(R.id.removeButton)
        removeButton.setOnClickListener {
            state = State.Changed
            state.apply(rootLayout, textView, removeButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(STATE_KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(STATE_KEY, State::class.java)!!
        } else {
            savedInstanceState.getSerializable(STATE_KEY) as State
        }
        state.apply(rootLayout, textView, removeButton)
    }

    private companion object {
        const val STATE_KEY = "state"
    }
}
