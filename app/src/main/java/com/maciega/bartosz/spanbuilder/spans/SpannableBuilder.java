package com.maciega.bartosz.spanbuilder.spans;

import android.graphics.MaskFilter;
import android.os.Parcel;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.maciega.bartosz.spanbuilder.spans.builders.BackgroundColorSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.ClickableSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.ForegroundColorSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.MaskFilterSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.UrlSpanBuilder;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

/**
 * Things to do:
 * - add span flags
 * - route spans to helper classes( separated by superclasses)
 */

public class SpannableBuilder {
    private SpannableStringBuilder spannableBuilder;
    private String text;
    private TextView textView;
    private int startIndex;
    private int endIndex;
    private int flags;


    public static SpannableBuilder newInstance(String text) {
        return new SpannableBuilder(text);
    }


    SpannableStringBuilder getSpannableBuilder() {
        return spannableBuilder;
    }

    private SpannableBuilder(String text) {
        this.text = text;
        spannableBuilder = new SpannableStringBuilder(text);
        startIndex = 0;
        endIndex = text.length();
        flags = Spanned.SPAN_INCLUSIVE_EXCLUSIVE;
    }


    public SpannableBuilder withBackgroundColor(int color) {
        BackgroundColorSpanBuilder builder = new BackgroundColorSpanBuilder(color);
        return builder.make(createProxy(startIndex, endIndex, flags));
    }

    public SpannableBuilder withBackgroundColor(Parcel parcel) {
        BackgroundColorSpanBuilder builder = new BackgroundColorSpanBuilder(parcel);
        return builder.make(createProxy(startIndex, endIndex, flags));
    }

    public SpannableBuilder withForegroundColor(int color) {
        ForegroundColorSpanBuilder builder = new ForegroundColorSpanBuilder(color);
        return builder.make(createProxy(startIndex, endIndex, flags));
    }

    public SpannableBuilder withForegroundColor(Parcel parcel) {
        ForegroundColorSpanBuilder builder = new ForegroundColorSpanBuilder(parcel);
        return builder.make(createProxy(startIndex, endIndex, flags));
    }

    public SpannableBuilder withClickable(View.OnClickListener listener) {
        ClickableSpanBuilder builder = new ClickableSpanBuilder(listener);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return builder.make(createProxy(startIndex, endIndex, flags));
    }

    public SpannableBuilder withUrl(String url) {
        UrlSpanBuilder builder = new UrlSpanBuilder(url);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return builder.make(createProxy(startIndex, endIndex, flags));
    }


    public SpannableBuilder withMask(MaskFilter mask) {
        MaskFilterSpanBuilder builder = new MaskFilterSpanBuilder(mask);
        return builder.make(createProxy(startIndex, endIndex, flags));
    }


    public SpannableBuilder changeFlags(int flags) {
        this.flags = flags;
        return this;
    }


    public SpannableBuilder resetFlags() {
        this.flags = Spanned.SPAN_INCLUSIVE_EXCLUSIVE;
        return this;
    }

    public SpannableBuilder changeIndex(int startIndex, int endIndex) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        return this;
    }

    public SpannableBuilder resetIndex() {
        this.startIndex = 0;
        this.endIndex = text.length();
        return this;
    }

    public SpannableStringBuilder get() {
        return spannableBuilder;
    }

    /**
     * If want to use textView directly with view this method must be invoked at the beginning of a chain
     * in order to retain all functionality
     */
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
