package com.maciega.bartosz.span_builder.spans.builders;

import android.os.Parcel;
import android.text.style.StyleSpan;

/**
 * Created by bartoszmaciega on 03/03/17.
 */

public class StyleSpanBuilder extends AbstractSpanTypeBuilder<StyleSpan> {

    public StyleSpanBuilder(int style) {
        span = new StyleSpan(style);
    }

    public StyleSpanBuilder(Parcel parcel) {
        span = new StyleSpan(parcel);
    }

}
