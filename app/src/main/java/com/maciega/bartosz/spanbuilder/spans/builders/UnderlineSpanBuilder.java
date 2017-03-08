package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.UnderlineSpan;

/**
 * Created by bartoszmaciega on 08/03/17.
 */

public class UnderlineSpanBuilder extends AbstractSpanTypeBuilder<UnderlineSpan> {

    public UnderlineSpanBuilder() {
        span = new UnderlineSpan();
    }

    public UnderlineSpanBuilder(Parcel src) {
        span = new UnderlineSpan(src);
    }

}
