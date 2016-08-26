package com.maciega.bartosz.spanbuilder.creators;

/**
 * Created by bartoszmaciega on 26/08/16.
 */
public class CreatorFactory {

    public static Creator get(CreatorType type){
        switch (type){
            case ABSOLUTE_SPAN:
                return new AbsoluteSpanCreator();
            case CUSTOM_TYPEFACE_SPAN:
                return new CustomTypefaceSpanCreator();

            default:
                throw new IllegalArgumentException("Chosen CreatorType is not supported");
        }
    }
}
