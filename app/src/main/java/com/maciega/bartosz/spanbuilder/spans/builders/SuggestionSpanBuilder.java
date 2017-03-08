package com.maciega.bartosz.spanbuilder.spans.builders;

import android.content.Context;
import android.os.Parcel;
import android.text.style.SuggestionSpan;

import java.util.Locale;

/**
 * Created by bartoszmaciega on 08/03/17.
 */

public class SuggestionSpanBuilder extends AbstractSpanTypeBuilder<SuggestionSpan> {

    public SuggestionSpanBuilder(Context context, String[] suggestions, int flags) {
        span = new SuggestionSpan(context, suggestions, flags);
    }

    public SuggestionSpanBuilder(Locale locale, String[] suggestions, int flags) {
        span = new SuggestionSpan(locale, suggestions, flags);
    }

    public SuggestionSpanBuilder(Context context, Locale locale, String[] suggestions, int flags, Class<?> notificationTargetClass) {
        span = new SuggestionSpan(context, locale, suggestions, flags, notificationTargetClass);
    }

    public SuggestionSpanBuilder(Parcel src) {
        span = new SuggestionSpan(src);
    }

}
