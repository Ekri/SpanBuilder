package com.maciega.bartosz.spanbuilder.spans;

import android.text.SpannableStringBuilder;

import com.maciega.bartosz.spanbuilder.spans.builders.BackgroundColorSpanBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class SpannableBuilder {
    private SpannableStringBuilder spannableBuilder;
    private String text;


    public static SpannableBuilder get(String text) {
        return new SpannableBuilder(text);
    }


    protected SpannableStringBuilder getSpannableBuilder() {
        return spannableBuilder;
    }

    private SpannableBuilder(String text) {
        this.text = text;
        spannableBuilder = new SpannableStringBuilder(text);
    }

    public SpannableBuilder withBackgroundColor(int color) {
        BackgroundColorSpanBuilder builder = new BackgroundColorSpanBuilder(color);
        return builder.make(createProxy(0, text.length()));
    }

    //TODO rethink flags
    private SpanProxy createProxy(int start, int end) {
        return new SpanProxy(this, text, start, end);
    }

}
