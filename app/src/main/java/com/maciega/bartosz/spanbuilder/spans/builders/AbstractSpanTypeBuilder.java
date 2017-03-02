package com.maciega.bartosz.spanbuilder.spans.builders;

import com.maciega.bartosz.spanbuilder.spans.SpanTypeBuilder;

/**
 * Created by bartoszmaciega on 02/03/17.
 */

public abstract class AbstractSpanTypeBuilder<T extends Object> implements SpanTypeBuilder {
    protected T span;
}
