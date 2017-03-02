package com.maciega.bartosz.spanbuilder.spans.builders;

import android.graphics.MaskFilter;
import android.text.style.MaskFilterSpan;

import com.maciega.bartosz.spanbuilder.spans.SpanProxy;
import com.maciega.bartosz.spanbuilder.spans.SpanTypeBuilder;
import com.maciega.bartosz.spanbuilder.spans.SpannableBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class MaskFilterSpanBuilder implements SpanTypeBuilder {

    private MaskFilterSpan span;

    public MaskFilterSpanBuilder(MaskFilter maskFilter) {
        span = new MaskFilterSpan(maskFilter);
    }

    @Override
    public SpannableBuilder make(SpanProxy proxy) {
        proxy.getSpannable().setSpan(span, proxy.startIndex(), proxy.endIndex(), proxy.flags());
        return proxy.send();
    }
}
