package com.maciega.bartosz.spanbuilder.spans;

import android.text.SpannableStringBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class SpannableBuilder {
    private SpannableStringBuilder spannableBuilder;
    private String text;


    public static SpannableBuilder get(String text) {
        return new SpannableBuilder(text);
    }

    private SpannableBuilder(String text) {
        this.text = text;
    }


}
