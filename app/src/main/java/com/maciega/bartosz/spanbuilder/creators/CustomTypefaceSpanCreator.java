package com.maciega.bartosz.spanbuilder.creators;

import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;

import com.maciega.bartosz.spanbuilder.CustomTypefaceSpan;

/**
 * Created by bartoszmaciega on 26/08/16.
 */
public class CustomTypefaceSpanCreator extends Creator {


    public  void create(@Nullable String family, Typeface typeface, SpannableStringBuilder builder,int start, int end){
        CustomTypefaceSpan typefaceSpan = new CustomTypefaceSpan(family == null ? "" : family, typeface);
        init(typefaceSpan);
        create(builder,start,end);
    }


    @Override
    protected void create(SpannableStringBuilder builder, int start, int end) {
        validateState();
        builder.setSpan(span,start,end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
    }
}
