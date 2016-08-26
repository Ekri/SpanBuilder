package com.maciega.bartosz.spanbuilder.creators;

import android.os.Parcel;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;

/**
 * Created by bartoszmaciega on 26/08/16.
 */
public class AbsoluteSpanCreator extends Creator {


    public void create(SpannableStringBuilder builder, int start, int end, int size, boolean isDip) {
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(size, isDip);
        init(absoluteSizeSpan);
        create(builder, start, end);
    }

    public void create(SpannableStringBuilder builder, int start, int end, Parcel src) {
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(src);
        init(absoluteSizeSpan);
        create(builder, start, end);
    }

    @Override
    protected void create(SpannableStringBuilder builder, int start, int end) {
        validateState();
        builder.setSpan(span, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }

}
