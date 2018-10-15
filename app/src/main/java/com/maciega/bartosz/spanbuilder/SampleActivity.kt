package com.maciega.bartosz.spanbuilder

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.maciega.bartosz.spanbuilder.spans.SpanBuilder

class SampleActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main)
    val textView = findViewById<TextView>(R.id.text)

    textView.text = SpanBuilder.builder(textView.text.toString()) {
      underline()
    }.build()
  }
}
