package com.maciega.bartosz.span_builder.spans.builders;

import android.graphics.drawable.Drawable;
import android.text.style.DrawableMarginSpan;

/**
 * Created by bartoszmaciega on 09/03/17.
 */

public class DrawableMarginSpanBuilder extends AbstractSpanTypeBuilder<DrawableMarginSpan> {

    public DrawableMarginSpanBuilder(Drawable drawable) {
        span = new DrawableMarginSpan(drawable);
    }

    public DrawableMarginSpanBuilder(Drawable drawable, int pad) {
        span = new DrawableMarginSpan(drawable, pad);
    }
}
