package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.ForegroundColorSpan;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class ForegroundColorSpanBuilder extends AbstractSpanTypeBuilder<ForegroundColorSpan> {

    public ForegroundColorSpanBuilder(int color) {
        span = new ForegroundColorSpan(color);
    }

    public ForegroundColorSpanBuilder(Parcel parcel) {
        span = new ForegroundColorSpan(parcel);
    }


}
