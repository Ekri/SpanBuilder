package com.maciega.bartosz.spanbuilder.spans.builders;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Parcel;
import android.text.style.TextAppearanceSpan;

/**
 * Created by bartoszmaciega on 08/03/17.
 */

public class TextAppearanceSpanBuilder extends AbstractSpanTypeBuilder<TextAppearanceSpan> {

    public TextAppearanceSpanBuilder(Context context, int appearance) {
        span = new TextAppearanceSpan(context, appearance);
    }

    public TextAppearanceSpanBuilder(Context context, int appearance, int colorList) {
        span = new TextAppearanceSpan(context, appearance, colorList);
    }

    public TextAppearanceSpanBuilder(String family, int style, int size,
                                     ColorStateList color, ColorStateList link) {
        span = new TextAppearanceSpan(family, style, size, color, link);
    }

    public TextAppearanceSpanBuilder(Parcel src) {
        span = new TextAppearanceSpan(src);
    }

}
