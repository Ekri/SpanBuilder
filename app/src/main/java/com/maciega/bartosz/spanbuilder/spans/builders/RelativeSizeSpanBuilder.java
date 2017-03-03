package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.RelativeSizeSpan;

/**
 * Created by bartoszmaciega on 03/03/17.
 */

public class RelativeSizeSpanBuilder extends AbstractSpanTypeBuilder<RelativeSizeSpan> {

    public RelativeSizeSpanBuilder(float proportion) {
        span = new RelativeSizeSpan(proportion);
    }

    public RelativeSizeSpanBuilder(Parcel parcel) {
        span = new RelativeSizeSpan(parcel);
    }

}
