package com.maciega.bartosz.spanbuilder;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;

/**
 * Created by bartoszmaciega on 25/08/16.
 */
public class CustomTypefaceSpan extends TypefaceSpan {
    private final Typeface newType;

    public CustomTypefaceSpan(String family, Typeface type) {
        super(family);
        this.newType = type;
    }

    public void updateDrawState(TextPaint ds) {
        applyCustomTypeFace(ds, this.newType);
    }

    public void updateMeasureState(TextPaint paint) {
        applyCustomTypeFace(paint, this.newType);
    }

    private static void applyCustomTypeFace(Paint paint, Typeface tf) {
        Typeface old = paint.getTypeface();
        int oldStyle;
        if(old == null) {
            oldStyle = 0;
        } else {
            oldStyle = old.getStyle();
        }

        int fake = oldStyle & ~tf.getStyle();
        if((fake & 1) != 0) {
            paint.setFakeBoldText(true);
        }

        if((fake & 2) != 0) {
            paint.setTextSkewX(-0.25F);
        }

        paint.setTypeface(tf);
    }
}
