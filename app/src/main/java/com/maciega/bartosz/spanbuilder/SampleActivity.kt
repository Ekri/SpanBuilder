package com.maciega.bartosz.spanbuilder

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.maciega.bartosz.spanbuilder.spans.SpanBuilder
import com.maciega.bartosz.spanbuilder.spans.withSpan

class SampleActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)
    val textView = findViewById<TextView>(R.id.text)
    withTextView(textView)
  }

  private fun builderDirectly(textView: TextView) {
    textView.text = SpanBuilder(textView.text.toString()) {
      backgroundColor(ContextCompat.getColor(this@SampleActivity, R.color.colorPrimary), end = 6)
    }.build()
  }

  private fun withTextView(textView: TextView) {
    textView.withSpan(textView.text.toString()) { tv ->
      foregroundColor(ContextCompat.getColor(tv.context, R.color.colorAccent), start = 1, end = 7)
      strikeThrough()
      quoteSpan(end = 4)
    }
  }
}
