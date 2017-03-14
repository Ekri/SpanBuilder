package com.maciega.bartosz.span_builder.spans.builders;

import com.maciega.bartosz.span_builder.spans.SpanBuilder;
import com.maciega.bartosz.span_builder.spans.SpanProxy;
import com.maciega.bartosz.span_builder.spans.SpanTypeBuilder;

/**
 * Created by bartoszmaciega on 02/03/17.
 */

public abstract class AbstractSpanTypeBuilder<T extends Object> implements SpanTypeBuilder {
    protected T span;


    @Override
    public SpanBuilder make(SpanProxy proxy) {
        proxy.getSpannable().setSpan(span,proxy.startIndex(),proxy.endIndex(),proxy.flags());
        return proxy.send();
    }
}
