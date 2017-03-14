package com.maciega.bartosz.span_builder.spans.builders;

import android.os.Parcel;
import android.text.style.TypefaceSpan;

/**
 * Created by bartoszmaciega on 08/03/17.
 */

public class TypeFaceSpanBuilder extends AbstractSpanTypeBuilder<TypefaceSpan> {


    public TypeFaceSpanBuilder(String family) {
        span = new TypefaceSpan(family);
    }

    public TypeFaceSpanBuilder(Parcel src) {
        span = new TypefaceSpan(src);
    }

}
