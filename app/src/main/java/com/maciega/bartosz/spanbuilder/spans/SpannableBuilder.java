package com.maciega.bartosz.spanbuilder.spans;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class SpannableBuilder {
    private SpannableStringBuilder spannableBuilder;
    private String text;


    public static SpannableBuilder get(String text) {
        return new SpannableBuilder(text);
    }


    protected SpannableStringBuilder getSpannableBuilder() {
        return spannableBuilder;
    }

    private SpannableBuilder(String text) {
        this.text = text;
        spannableBuilder = new SpannableStringBuilder(text);
    }

    public SpannableBuilder withBackgroundColor(int color) {
        spannableBuilder.setSpan(new BackgroundColorSpan(color), 0, text.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        return this;
    }

}
