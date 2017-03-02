package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.ForegroundColorSpan;

import com.maciega.bartosz.spanbuilder.spans.SpanProxy;
import com.maciega.bartosz.spanbuilder.spans.SpanTypeBuilder;
import com.maciega.bartosz.spanbuilder.spans.SpannableBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class ForegroundColorSpanBuilder implements SpanTypeBuilder {
    ForegroundColorSpan span;


    public ForegroundColorSpanBuilder(int color) {
        span = new ForegroundColorSpan(color);
    }

    public ForegroundColorSpanBuilder(Parcel parcel) {
        span = new ForegroundColorSpan(parcel);
    }


    @Override
    public SpannableBuilder make(SpanProxy proxy) {
        proxy.getSpannable().setSpan(span, proxy.startIndex(), proxy.endIndex(), proxy.flags());
        return proxy.send();
    }
}
