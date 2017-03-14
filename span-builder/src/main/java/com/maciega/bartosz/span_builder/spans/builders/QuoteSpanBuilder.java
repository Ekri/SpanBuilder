package com.maciega.bartosz.span_builder.spans.builders;

import android.os.Parcel;
import android.text.style.QuoteSpan;

/**
 * Created by bartoszmaciega on 09/03/17.
 */

public class QuoteSpanBuilder extends AbstractSpanTypeBuilder<QuoteSpan> {

    public QuoteSpanBuilder() {
        span = new QuoteSpan();
    }

    public QuoteSpanBuilder(int color) {
        span = new QuoteSpan(color);
    }

    public QuoteSpanBuilder(Parcel src) {
        span = new QuoteSpan(src);
    }

}
