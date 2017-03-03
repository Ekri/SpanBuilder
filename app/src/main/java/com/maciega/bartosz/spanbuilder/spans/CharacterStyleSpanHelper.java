package com.maciega.bartosz.spanbuilder.spans;

import com.maciega.bartosz.spanbuilder.spans.builders.BackgroundColorSpanBuilder;

/**
 * Created by bartoszmaciega on 03/03/17.
 */


/**
 * This delegation should be nice but rethink if we do not have too many methods in this lib because of this
 */
public class CharacterStyleSpanHelper {


    public static CharacterStyleSpanHelper getInstance() {
        return new CharacterStyleSpanHelper();
    }


    private CharacterStyleSpanHelper() {

    }

    public SpannableBuilder withBackgroundColor(int color, SpanProxy proxy) {
        BackgroundColorSpanBuilder builder = new BackgroundColorSpanBuilder(color);
        return builder.make(proxy);
    }


}
