package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

interface State : Serializable {

    fun apply(rootLayout: LinearLayout, textView: TextView, button: Button)

    object Initial : State {

        override fun apply(rootLayout: LinearLayout, textView: TextView, button: Button) = Unit
    }

    object Changed : State {

        override fun apply(rootLayout: LinearLayout, textView: TextView, button: Button) {
            rootLayout.removeView(textView)
            button.isEnabled = false
        }
    }
}
