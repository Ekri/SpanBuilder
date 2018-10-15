package com.maciega.bartosz.spanbuilder.spans.builders;

import android.text.style.TabStopSpan;

/**
 * Created by bartoszmaciega on 09/03/17.
 */

public class TabStopStandardSpanBuilder extends AbstractSpanTypeBuilder<TabStopSpan.Standard> {

    public TabStopStandardSpanBuilder(int where){
        span = new TabStopSpan.Standard(where);
    }
}
