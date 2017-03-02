package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.BackgroundColorSpan;

import com.maciega.bartosz.spanbuilder.spans.SpanProxy;
import com.maciega.bartosz.spanbuilder.spans.SpanTypeBuilder;
import com.maciega.bartosz.spanbuilder.spans.SpannableBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class BackgroundColorSpanBuilder extends AbstractSpanTypeBuilder<BackgroundColorSpan> {

    public BackgroundColorSpanBuilder(int color) {
        span = new BackgroundColorSpan(color);
    }

    public BackgroundColorSpanBuilder(Parcel parcel) {
        span = new BackgroundColorSpan(parcel);
    }


    @Override
    public SpannableBuilder make(SpanProxy proxy) {
        proxy.getSpannable().setSpan(span, proxy.startIndex(), proxy.endIndex(), proxy.flags());
        return proxy.send();
    }
}
