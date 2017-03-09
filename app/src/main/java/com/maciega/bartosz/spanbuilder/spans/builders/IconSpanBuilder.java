package com.maciega.bartosz.spanbuilder.spans.builders;

import android.graphics.Bitmap;
import android.text.style.IconMarginSpan;

/**
 * Created by bartoszmaciega on 09/03/17.
 */

public class IconSpanBuilder extends AbstractSpanTypeBuilder<IconMarginSpan> {

    public IconSpanBuilder(Bitmap bitmap) {
        span = new IconMarginSpan(bitmap);
    }

    public IconSpanBuilder(Bitmap bitmap, int pad) {
        span = new IconMarginSpan(bitmap, pad);
    }
}
