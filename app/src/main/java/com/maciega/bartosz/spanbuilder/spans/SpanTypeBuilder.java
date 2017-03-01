package com.maciega.bartosz.spanbuilder.spans;

import android.text.SpannableStringBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public interface SpanTypeBuilder {
    SpannableBuilder make(SpanProxy proxy);
}
