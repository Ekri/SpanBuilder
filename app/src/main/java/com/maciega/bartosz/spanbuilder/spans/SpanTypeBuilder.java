package com.maciega.bartosz.spanbuilder.spans;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public interface SpanTypeBuilder<T extends Object> {
    T create();
}
