package com.maciega.bartosz.span_builder.spans.builders;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.LocaleList;
import android.os.Parcel;
import android.text.style.LocaleSpan;

import java.util.Locale;

/**
 * Created by bartoszmaciega on 03/03/17.
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class LocaleSpanBuilder extends AbstractSpanTypeBuilder<LocaleSpan> {

    public LocaleSpanBuilder(Locale locale) {
        span = new LocaleSpan(locale);
    }

    @TargetApi(Build.VERSION_CODES.N)
    public LocaleSpanBuilder(LocaleList localeList) {
        span = new LocaleSpan(localeList);
    }

    public LocaleSpanBuilder(Parcel parcel) {
        span = new LocaleSpan(parcel);
    }


}
