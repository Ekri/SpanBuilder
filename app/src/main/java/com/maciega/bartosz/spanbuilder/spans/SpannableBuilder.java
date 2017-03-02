package com.maciega.bartosz.spanbuilder.spans;

import android.os.Parcel;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.maciega.bartosz.spanbuilder.spans.builders.BackgroundColorSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.ClickableSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.ForegroundColorSpanBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

/**
 * Things to do:
 * - add span flags
 *
 */

public class SpannableBuilder {
    private SpannableStringBuilder spannableBuilder;
    private String text;
    private TextView textView;


    public static SpannableBuilder newInstance(String text) {
        return new SpannableBuilder(text);
    }


    SpannableStringBuilder getSpannableBuilder() {
        return spannableBuilder;
    }

    private SpannableBuilder(String text) {
        this.text = text;
        spannableBuilder = new SpannableStringBuilder(text);
    }

    public SpannableBuilder withBackgroundColor(int color) {
        BackgroundColorSpanBuilder builder = new BackgroundColorSpanBuilder(color);
        return builder.make(createProxy(0, text.length()));
    }

    public SpannableBuilder withBackgroundColor(Parcel parcel) {
        BackgroundColorSpanBuilder builder = new BackgroundColorSpanBuilder(parcel);
        return builder.make(createProxy(0, text.length()));
    }

    public SpannableBuilder withForegroundColor(int color) {
        ForegroundColorSpanBuilder builder = new ForegroundColorSpanBuilder(color);
        return builder.make(createProxy(0, text.length()));
    }

    public SpannableBuilder withForegroundColor(Parcel parcel) {
        ForegroundColorSpanBuilder builder = new ForegroundColorSpanBuilder(parcel);
        return builder.make(createProxy(0, text.length()));
    }

    public SpannableBuilder withClickable(View.OnClickListener listener, int start, int end) {
        ClickableSpanBuilder builder = new ClickableSpanBuilder(listener);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return builder.make(createProxy(start, end));
    }


    public SpannableStringBuilder get() {
        return spannableBuilder;
    }

    public SpannableBuilder withView(TextView textView) {
        this.textView = textView;
        return this;
    }

    public void make() {
        if (textView == null)
            throw new IllegalStateException("Cannot call make() without calling withView()");
        textView.setText(spannableBuilder);
    }


    //TODO rethink flags
    private SpanProxy createProxy(int start, int end) {
        return new SpanProxy(this, text, start, end);
    }

    private SpanProxy createProxy(int start, int end, int flags) {
        return new SpanProxy(this, text, start, end, flags);
    }

}
