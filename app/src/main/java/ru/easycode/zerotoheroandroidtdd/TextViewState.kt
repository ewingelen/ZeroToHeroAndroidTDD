package ru.easycode.zerotoheroandroidtdd

import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

interface TextViewState : Serializable {

    fun apply(rootLayout: LinearLayout, textView: TextView)

    object Initial : TextViewState {

        override fun apply(rootLayout: LinearLayout, textView: TextView) = Unit
    }

    object Removed : TextViewState {

        override fun apply(rootLayout: LinearLayout, textView: TextView) {
            rootLayout.removeView(textView)
        }
    }
}
