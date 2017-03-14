package com.maciega.bartosz.span_builder.spans;

import com.maciega.bartosz.span_builder.spans.builders.BackgroundColorSpanBuilder;

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

    public SpanBuilder withBackgroundColor(int color, SpanProxy proxy) {
        BackgroundColorSpanBuilder builder = new BackgroundColorSpanBuilder(color);
        return builder.make(proxy);
    }


}
