package com.maciega.bartosz.span_builder.spans;

import android.support.annotation.NonNull;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

/**
 * Created by bartoszmaciega on 01/03/17.
 */

public class SpanProxy {

    private SpanBuilder builder;
    private String text;
    private int start = 0;
    private int end = 0;
    private int flags = Spanned.SPAN_INCLUSIVE_EXCLUSIVE;

    public SpanProxy(SpanBuilder builder, @NonNull String text) {
        this(builder, text, 0, 0);
    }

    public SpanProxy(SpanBuilder builder, @NonNull String text, int start, int end) {
        this(builder, text, start, end, -1);
    }

    public SpanProxy(SpanBuilder builder, @NonNull String text, int start, int end, int flags) {
        this.builder = builder;
        this.text = text;
        this.start = start;
        this.end = end > 0 ? end : text.length();
        if (flags > 0) {
            this.flags = flags;
        }
    }

    public SpanBuilder send() {
        return builder;
    }

    public SpannableStringBuilder getSpannable() {
        return builder.getSpannableBuilder();
    }

    public int endIndex() {
        return end;
    }

    public int startIndex() {
        return start;
    }

    public String text() {
        return text;
    }

    public int flags() {
        return flags;
    }
}
