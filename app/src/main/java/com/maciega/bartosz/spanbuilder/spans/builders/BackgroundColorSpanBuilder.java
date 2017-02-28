package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.BackgroundColorSpan;

import com.maciega.bartosz.spanbuilder.spans.SpanTypeBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class BackgroundColorSpanBuilder implements SpanTypeBuilder<BackgroundColorSpan> {

    private BackgroundColorSpan span;

    public BackgroundColorSpanBuilder(int color) {
        span = new BackgroundColorSpan(color);
    }

    public BackgroundColorSpanBuilder(Parcel parcel) {
        span = new BackgroundColorSpan(parcel);
    }


    @Override
    public BackgroundColorSpan create() {
        return span;
    }
}
