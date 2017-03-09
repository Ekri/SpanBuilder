package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.BulletSpan;

/**
 * Created by bartoszmaciega on 08/03/17.
 */

public class BulletSpanBuilder extends AbstractSpanTypeBuilder<BulletSpan> {

    public BulletSpanBuilder() {
        span = new BulletSpan();
    }

    public BulletSpanBuilder(int gapWidth) {
        span = new BulletSpan(gapWidth);
    }

    public BulletSpanBuilder(int gapWidth, int color) {
        span = new BulletSpan(gapWidth, color);
    }

    public BulletSpanBuilder(Parcel src) {
        span = new BulletSpan(src);
    }

}
