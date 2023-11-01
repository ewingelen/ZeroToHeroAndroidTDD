package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var textViewState: TextViewState = TextViewState.Initial
    private lateinit var rootLayout: LinearLayout
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rootLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        val removeButton = findViewById<Button>(R.id.removeButton)
        removeButton.setOnClickListener {
            textViewState = TextViewState.Removed
            textViewState.apply(rootLayout, textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(TEXT_VIEW_STATE_KEY, textViewState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(TEXT_VIEW_STATE_KEY, TextViewState::class.java)!!
        } else {
            @Suppress("DEPRECATION")
            savedInstanceState.getSerializable(TEXT_VIEW_STATE_KEY) as TextViewState
        }
        state.apply(rootLayout, textView)
    }

    private companion object {
        const val TEXT_VIEW_STATE_KEY = "text_view_state"
    }
}
