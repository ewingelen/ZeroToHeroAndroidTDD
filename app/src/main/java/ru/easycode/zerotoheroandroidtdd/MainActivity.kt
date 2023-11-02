package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val incrementButton = findViewById<Button>(R.id.incrementButton)
        val countTextView = findViewById<TextView>(R.id.countTextView)
        val count: Count = Count.Base(step = 2)
        incrementButton.setOnClickListener {
            val result = count.increment(countTextView.text.toString())
            countTextView.text = result
        }
    }
}
