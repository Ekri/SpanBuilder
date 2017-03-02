package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.URLSpan;

import com.maciega.bartosz.spanbuilder.spans.SpanProxy;
import com.maciega.bartosz.spanbuilder.spans.SpannableBuilder;

/**
 * Created by bartoszmaciega on 02/03/17.
 */

public class UrlSpanBuilder extends AbstractSpanTypeBuilder<URLSpan> {


    public UrlSpanBuilder(String url) {
        span = new URLSpan(url);
    }

    public UrlSpanBuilder(Parcel parcel) {
        span = new URLSpan(parcel);
    }


    @Override
    public SpannableBuilder make(SpanProxy proxy) {
        proxy.getSpannable().setSpan(span, proxy.startIndex(), proxy.endIndex(), proxy.flags());
        return proxy.send();
    }
}
