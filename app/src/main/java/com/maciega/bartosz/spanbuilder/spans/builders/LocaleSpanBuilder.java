package com.maciega.bartosz.spanbuilder.spans.builders;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.style.LocaleSpan;

import com.maciega.bartosz.spanbuilder.spans.SpanProxy;
import com.maciega.bartosz.spanbuilder.spans.SpannableBuilder;

import java.util.Locale;

/**
 * Created by bartoszmaciega on 03/03/17.
 */
@TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
public class LocaleSpanBuilder extends AbstractSpanTypeBuilder<LocaleSpan> {

    public LocaleSpanBuilder(Locale locale){
        span = new LocaleSpan(locale);
    }

    @Override
    public SpannableBuilder make(SpanProxy proxy) {
        proxy.getSpannable().setSpan(span,proxy.startIndex(),proxy.endIndex(),proxy.flags());
        return proxy.send();
    }
}
