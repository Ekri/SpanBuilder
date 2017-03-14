package com.maciega.bartosz.span_builder.spans.builders;

import android.os.Parcel;
import android.text.style.ScaleXSpan;

/**
 * Created by bartoszmaciega on 03/03/17.
 */

public class ScaleXSpanBuilder extends AbstractSpanTypeBuilder<ScaleXSpan> {

    public ScaleXSpanBuilder(float proportion){
        span = new ScaleXSpan(proportion);
    }

    public ScaleXSpanBuilder(Parcel parcel){
        span = new ScaleXSpan(parcel);
    }

}
