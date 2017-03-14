package com.maciega.bartosz.spanbuilder.spans.builders;

import com.maciega.bartosz.spanbuilder.spans.SpanProxy;
import com.maciega.bartosz.spanbuilder.spans.SpanTypeBuilder;
import com.maciega.bartosz.spanbuilder.spans.SpanBuilder;

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
