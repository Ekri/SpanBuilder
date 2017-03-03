package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.AbsoluteSizeSpan;

import com.maciega.bartosz.spanbuilder.spans.SpanProxy;
import com.maciega.bartosz.spanbuilder.spans.SpannableBuilder;

/**
 * Created by bartoszmaciega on 03/03/17.
 */

public class AbsoluteSizeSpanBuilder extends AbstractSpanTypeBuilder<AbsoluteSizeSpan> {

    public AbsoluteSizeSpanBuilder(int size, boolean dip) {
        span = new AbsoluteSizeSpan(size, dip);
    }

    public AbsoluteSizeSpanBuilder(Parcel parcel) {
        span = new AbsoluteSizeSpan(parcel);
    }

    @Override
    public SpannableBuilder make(SpanProxy proxy) {
        proxy.getSpannable().setSpan(span, proxy.startIndex(), proxy.endIndex(), proxy.flags());
        return proxy.send();
    }
}
