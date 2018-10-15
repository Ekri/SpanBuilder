package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.URLSpan;

/**
 * Created by bartoszmaciega on 02/03/17.
 */

public class UrlSpanBuilder extends AbstractSpanTypeBuilder<URLSpan> {


    public UrlSpanBuilder(String url) {
        span = new URLSpan(url);
    }

    public UrlSpanBuilder(Parcel parcel) {
        span = new URLSpan(parcel);
    }


}
