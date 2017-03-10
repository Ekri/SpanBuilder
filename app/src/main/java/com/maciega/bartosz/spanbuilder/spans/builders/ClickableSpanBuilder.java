package com.maciega.bartosz.spanbuilder.spans.builders;

import android.text.style.ClickableSpan;
import android.view.View;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class ClickableSpanBuilder extends AbstractSpanTypeBuilder<ClickableSpan> {


    public ClickableSpanBuilder(final View.OnClickListener listener) {
        span = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                listener.onClick(widget);
            }
        };
    }

}
