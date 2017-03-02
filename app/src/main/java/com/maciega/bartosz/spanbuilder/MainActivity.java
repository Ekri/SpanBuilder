package com.maciega.bartosz.spanbuilder;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.maciega.bartosz.spanbuilder.spans.SpannableBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextView textView = (TextView) findViewById(R.id.text);
        SpannableBuilder.newInstance(textView.getText().toString())
                .withView(textView)
                .withBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .make();
    }
}
