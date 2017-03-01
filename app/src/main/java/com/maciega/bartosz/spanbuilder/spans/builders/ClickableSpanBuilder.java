package com.maciega.bartosz.spanbuilder.spans.builders;

import android.text.style.ClickableSpan;

import com.maciega.bartosz.spanbuilder.spans.SpanProxy;
import com.maciega.bartosz.spanbuilder.spans.SpanTypeBuilder;
import com.maciega.bartosz.spanbuilder.spans.SpannableBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class ClickableSpanBuilder implements SpanTypeBuilder<ClickableSpan> {
    ClickableSpan span;


//TODO fill this later


    @Override
    public ClickableSpan create() {
        return span;
    }

    @Override
    public SpannableBuilder make(SpanProxy proxy) {
        return  null;
    }
}
