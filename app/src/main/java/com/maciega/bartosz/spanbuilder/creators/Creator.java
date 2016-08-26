package com.maciega.bartosz.spanbuilder.creators;

import android.text.SpannableStringBuilder;

/**
 * Created by bartoszmaciega on 26/08/16.
 */
public abstract class Creator {
    protected Object span;

    protected void validateState(){
        if(this.span == null)
            throw  new IllegalStateException("Span object cannot be null, must call init()");
    }

    protected abstract void create(SpannableStringBuilder builder, int start, int end);


    protected void init(Object what) {
        if(what == null)
            throw new IllegalArgumentException("Span object cannot be null");
        this.span = what;
    }
}
