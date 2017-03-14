package com.maciega.bartosz.span_builder.spans.builders;

import android.graphics.MaskFilter;
import android.text.style.MaskFilterSpan;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class MaskFilterSpanBuilder extends AbstractSpanTypeBuilder<MaskFilterSpan> {


    public MaskFilterSpanBuilder(MaskFilter maskFilter) {
        span = new MaskFilterSpan(maskFilter);
    }

}
