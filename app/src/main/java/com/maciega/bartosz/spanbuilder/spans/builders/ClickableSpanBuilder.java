package com.maciega.bartosz.spanbuilder.spans.builders;

import android.text.style.ClickableSpan;
import android.view.View;

import com.maciega.bartosz.spanbuilder.spans.SpanProxy;
import com.maciega.bartosz.spanbuilder.spans.SpanTypeBuilder;
import com.maciega.bartosz.spanbuilder.spans.SpannableBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

public class ClickableSpanBuilder implements SpanTypeBuilder {
    ClickableSpan span;

    private View.OnClickListener listener;

//TODO fill this later

    public ClickableSpanBuilder(final View.OnClickListener listener) {
        span = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                listener.onClick(widget);
            }
        };
    }


    @Override
    public SpannableBuilder make(SpanProxy proxy) {
        proxy.getSpannable().setSpan(span,proxy.startIndex(),proxy.endIndex(),proxy.flags());
        return proxy.send();
    }
}
