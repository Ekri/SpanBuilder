package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.BackgroundColorSpan;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class BackgroundColorSpanBuilder extends AbstractSpanTypeBuilder<BackgroundColorSpan> {

    public BackgroundColorSpanBuilder(int color) {
        span = new BackgroundColorSpan(color);
    }

    public BackgroundColorSpanBuilder(Parcel parcel) {
        span = new BackgroundColorSpan(parcel);
    }

}
