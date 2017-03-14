package com.maciega.bartosz.span_builder.spans.builders;

import android.os.Parcel;
import android.text.style.AbsoluteSizeSpan;

/**
 * Created by bartoszmaciega on 03/03/17.
 */

public class AbsoluteSizeSpanBuilder extends AbstractSpanTypeBuilder<AbsoluteSizeSpan> {

    public AbsoluteSizeSpanBuilder(int size, boolean dip) {
        span = new AbsoluteSizeSpan(size, dip);
    }

    public AbsoluteSizeSpanBuilder(Parcel parcel) {
        span = new AbsoluteSizeSpan(parcel);
    }

}
