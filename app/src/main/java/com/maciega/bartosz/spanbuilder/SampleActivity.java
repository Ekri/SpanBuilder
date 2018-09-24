package com.maciega.bartosz.spanbuilder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.maciega.bartosz.span_builder.spans.SpanBuilder;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView textView = findViewById(R.id.text);
        SpanBuilder.newInstance(textView.getText().toString())
                .withView(textView)
                .index(0, 5)
                .resetIndex()
                .withQuote()
                .buildWithTextView();
    }
}
