package com.maciega.bartosz.spanbuilder.spans.builders;

import android.graphics.MaskFilter;
import android.text.style.MaskFilterSpan;

import com.maciega.bartosz.spanbuilder.spans.SpanTypeBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class MaskFilterSpanBuilder implements SpanTypeBuilder<MaskFilterSpan> {

    private MaskFilterSpan span;

    public MaskFilterSpanBuilder(MaskFilter maskFilter) {
        span = new MaskFilterSpan(maskFilter);
    }

    @Override
    public MaskFilterSpan create() {
        return span;
    }
}
