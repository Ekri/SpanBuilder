package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.style.StrikethroughSpan;

/**
 * Created by bartoszmaciega on 08/03/17.
 */

public class StrikeThroughSpanBuilder extends AbstractSpanTypeBuilder<StrikethroughSpan> {


    public StrikeThroughSpanBuilder(){
        span = new StrikethroughSpan();
    }

    public StrikeThroughSpanBuilder(Parcel src){
        span = new StrikethroughSpan(src);
    }
}
