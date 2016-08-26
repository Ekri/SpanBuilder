package com.maciega.bartosz.spanbuilder;

import android.graphics.Typeface;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;

import com.maciega.bartosz.spanbuilder.creators.AbsoluteSpanCreator;
import com.maciega.bartosz.spanbuilder.creators.CreatorFactory;
import com.maciega.bartosz.spanbuilder.creators.CreatorType;
import com.maciega.bartosz.spanbuilder.creators.CustomTypefaceSpanCreator;

/**
 * Created by bartoszmaciega on 25/08/16.
 */
public class SpanBuilder {

    private SpannableStringBuilder spannableBuilder;
    private String text;


    public static final SpanBuilder get(String text) {
        SpanBuilder instance = new SpanBuilder(text);
        return instance;
    }

    private SpanBuilder(String text) {
        this.text = text;
        spannableBuilder = new SpannableStringBuilder(text);
    }


    public SpanBuilder withAbsoluteSpan(int size, boolean isDip, int start, int end) {
        checkBounds(start,end);
        AbsoluteSpanCreator absoluteSpanCreator = (AbsoluteSpanCreator) CreatorFactory.get(CreatorType.ABSOLUTE_SPAN);
        absoluteSpanCreator.create(spannableBuilder, start, end, size, isDip);
        return this;
    }

    public SpanBuilder withAbsoluteSpan(Parcel src, int start, int end) {
        checkBounds(start,end);
        AbsoluteSpanCreator absoluteSizeSpan = (AbsoluteSpanCreator) CreatorFactory.get(CreatorType.ABSOLUTE_SPAN);
        absoluteSizeSpan.create(spannableBuilder, start, end, src);
        return this;
    }


    public SpanBuilder withFont(@Nullable String family, Typeface typeface) {
        return withFont(family, typeface, 0, text.length());
    }

    public SpanBuilder withFont(@Nullable String family, Typeface typeface, int start, int end) {
        checkBounds(start,end);
        CustomTypefaceSpanCreator customTypefaceSpanCreator = (CustomTypefaceSpanCreator) CreatorFactory.get(CreatorType.CUSTOM_TYPEFACE_SPAN);
        customTypefaceSpanCreator.create(family,typeface,spannableBuilder,start,end);
        return this;
    }

    public SpanBuilder withUnderline(int start, int end) {
        checkBounds(start,end);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        spannableBuilder.setSpan(underlineSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return this;
    }


    public SpanBuilder withColouredText(int color, int start, int end) {
       checkBounds(start,end);
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(color);
        spannableBuilder.setSpan(colorSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return this;
    }


    //TODO change to some interface not pass clickable span directly, back there when will be some time, and to make clickable working must set movement method, and additionaly change color of clickable text
    public SpanBuilder withClickable(int start, int end, ClickableSpan clickableSpan) {
        spannableBuilder.setSpan(clickableSpan, start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return this;
    }

    public SpannableStringBuilder create() {
        return spannableBuilder;
    }

    private void checkBounds(int start, int end){
        if(start < 0 || start > text.length())
            throw  new IllegalArgumentException("Start index out of text bounds");
        if(start > end)
            throw new IllegalArgumentException("Start cannot be higher than end");

        if(end < 0 || end > text.length())
            throw  new IllegalArgumentException("End index out of text bounds");
        if(end < start)
            throw new IllegalArgumentException("End cannot be smaller than start");

    }

}

