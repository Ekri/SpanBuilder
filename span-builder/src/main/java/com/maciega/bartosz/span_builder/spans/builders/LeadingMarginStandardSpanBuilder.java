package com.maciega.bartosz.span_builder.spans.builders;

import android.os.Parcel;
import android.text.style.LeadingMarginSpan;

/**
 * Created by bartoszmaciega on 09/03/17.
 */

public class LeadingMarginStandardSpanBuilder extends AbstractSpanTypeBuilder<LeadingMarginSpan.Standard> {

    public LeadingMarginStandardSpanBuilder(int first, int rest) {
        span = new LeadingMarginSpan.Standard(first, rest);
    }

    public LeadingMarginStandardSpanBuilder(int every) {
        span = new LeadingMarginSpan.Standard(every);
    }

    public LeadingMarginStandardSpanBuilder(Parcel src) {
        span = new LeadingMarginSpan.Standard(src);
    }

}
