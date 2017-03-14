package com.maciega.bartosz.span_builder.spans;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.MaskFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import android.os.Parcel;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import com.maciega.bartosz.span_builder.spans.builders.AbsoluteSizeSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.BackgroundColorSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.ClickableSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.DrawableMarginSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.ForegroundColorSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.IconMarginSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.IconSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.ImageSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.MaskFilterSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.StyleSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.SuggestionSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.TextAppearanceSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.AlignmentSpanStandardBuilder;
import com.maciega.bartosz.span_builder.spans.builders.BulletSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.LeadingMarginStandardSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.LocaleSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.QuoteSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.RelativeSizeSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.ScaleXSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.StrikeThroughSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.TabStopStandardSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.TypeFaceSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.UnderlineSpanBuilder;
import com.maciega.bartosz.span_builder.spans.builders.UrlSpanBuilder;

import java.util.Locale;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

/**
 * Things to do:
 * - route spans to helper classes( separated by superclasses)
 * - rethink if should remove constructors with parcel
 */

public class SpanBuilder {
    private SpannableStringBuilder spannableBuilder;
    private String text;
    private TextView textView;
    private int startIndex;
    private int endIndex;
    private int flags;


    public static SpanBuilder newInstance(String text) {
        return new SpanBuilder(text);
    }


    SpannableStringBuilder getSpannableBuilder() {
        return spannableBuilder;
    }

    private SpanBuilder(String text) {
        this.text = text;
        spannableBuilder = new SpannableStringBuilder(text);
        startIndex = 0;
        endIndex = text.length();
        flags = Spanned.SPAN_INCLUSIVE_EXCLUSIVE;
    }

    public SpanBuilder withBackgroundColor(int color) {
        BackgroundColorSpanBuilder builder = new BackgroundColorSpanBuilder(color);
        return makeSpan(builder);
    }

    public SpanBuilder withBackgroundColor(Parcel src) {
        BackgroundColorSpanBuilder builder = new BackgroundColorSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withForegroundColor(int color) {
        ForegroundColorSpanBuilder builder = new ForegroundColorSpanBuilder(color);
        return makeSpan(builder);
    }

    public SpanBuilder withForegroundColor(Parcel src) {
        ForegroundColorSpanBuilder builder = new ForegroundColorSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withClickable(View.OnClickListener listener) {
        ClickableSpanBuilder builder = new ClickableSpanBuilder(listener);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return makeSpan(builder);
    }

    public SpanBuilder withUrl(String url) {
        UrlSpanBuilder builder = new UrlSpanBuilder(url);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return makeSpan(builder);
    }

    public SpanBuilder withMask(MaskFilter mask) {
        MaskFilterSpanBuilder builder = new MaskFilterSpanBuilder(mask);
        return makeSpan(builder);
    }

    public SpanBuilder withAbsoluteSize(int size) {
        AbsoluteSizeSpanBuilder builder = new AbsoluteSizeSpanBuilder(size, false);
        return makeSpan(builder);
    }

    public SpanBuilder withAbsoluteSize(int size, boolean dip) {
        AbsoluteSizeSpanBuilder builder = new AbsoluteSizeSpanBuilder(size, dip);
        return makeSpan(builder);
    }

    public SpanBuilder withAbsoluteSize(Parcel src) {
        AbsoluteSizeSpanBuilder builder = new AbsoluteSizeSpanBuilder(src);
        return makeSpan(builder);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public SpanBuilder withLocale(Locale locale) {
        LocaleSpanBuilder builder = new LocaleSpanBuilder(locale);
        return makeSpan(builder);
    }

    @TargetApi(Build.VERSION_CODES.N)
    public SpanBuilder withLocale(LocaleList localeList) {
        LocaleSpanBuilder builder = new LocaleSpanBuilder(localeList);
        return makeSpan(builder);
    }

    public SpanBuilder withLocale(Parcel src) {
        LocaleSpanBuilder builder = new LocaleSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withRelative(float proportion) {
        RelativeSizeSpanBuilder builder = new RelativeSizeSpanBuilder(proportion);
        return makeSpan(builder);
    }

    public SpanBuilder withRelative(Parcel src) {
        RelativeSizeSpanBuilder builder = new RelativeSizeSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withImage(Context context, Bitmap bitmap) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, bitmap);
        return makeSpan(builder);
    }

    public SpanBuilder withImage(Context context, Bitmap bitmap, int verticalAlignment) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, bitmap, verticalAlignment);
        return makeSpan(builder);
    }

    public SpanBuilder withImage(Drawable drawable) {
        ImageSpanBuilder builder = new ImageSpanBuilder(drawable);
        return makeSpan(builder);
    }

    public SpanBuilder withImage(Drawable drawable, String source) {
        ImageSpanBuilder builder = new ImageSpanBuilder(drawable, source);
        return makeSpan(builder);
    }

    public SpanBuilder withImage(Drawable drawable, int verticalAlignment) {
        ImageSpanBuilder builder = new ImageSpanBuilder(drawable, verticalAlignment);
        return makeSpan(builder);
    }

    public SpanBuilder withImage(Drawable drawable, String source, int verticalAlignment) {
        ImageSpanBuilder builder = new ImageSpanBuilder(drawable, source, verticalAlignment);
        return makeSpan(builder);
    }

    public SpanBuilder withImage(Context context, Uri uri) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, uri);
        return makeSpan(builder);
    }

    public SpanBuilder withImage(Context context, Uri uri, int verticalAlignment) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, uri, verticalAlignment);
        return makeSpan(builder);
    }

    public SpanBuilder withImage(Context context, int resourceId) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, resourceId);
        return makeSpan(builder);
    }

    public SpanBuilder withImage(Context context, int resourceId, int verticalAlignment) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, resourceId, verticalAlignment);
        return makeSpan(builder);
    }

    public SpanBuilder withXScale(float proportion) {
        ScaleXSpanBuilder builder = new ScaleXSpanBuilder(proportion);
        return makeSpan(builder);
    }

    public SpanBuilder withXScale(Parcel src) {
        ScaleXSpanBuilder builder = new ScaleXSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withStyle(int style) {
        StyleSpanBuilder builder = new StyleSpanBuilder(style);
        return makeSpan(builder);
    }

    public SpanBuilder withStyle(Parcel src) {
        StyleSpanBuilder builder = new StyleSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withTypeface(String family) {
        TypeFaceSpanBuilder builder = new TypeFaceSpanBuilder(family);
        return makeSpan(builder);
    }

    public SpanBuilder withTypeface(Parcel src) {
        TypeFaceSpanBuilder builder = new TypeFaceSpanBuilder(src);
        return makeSpan(builder);
    }


    /**
     * Subscript and superscript span skipped intentionally , test its behavior in future
     */


    public SpanBuilder withTextAppearance(Context context, int appearance) {
        TextAppearanceSpanBuilder builder = new TextAppearanceSpanBuilder(context, appearance);
        return makeSpan(builder);
    }

    public SpanBuilder withTextAppearance(Context context, int appearance, int colorList) {
        TextAppearanceSpanBuilder builder = new TextAppearanceSpanBuilder(context, appearance, colorList);
        return makeSpan(builder);
    }

    public SpanBuilder withTextAppearance(String family, int style, int size, ColorStateList color, ColorStateList linkColor) {
        TextAppearanceSpanBuilder builder = new TextAppearanceSpanBuilder(family, style, size, color, linkColor);
        return makeSpan(builder);
    }

    public SpanBuilder withTextAppearance(Parcel src) {
        TextAppearanceSpanBuilder builder = new TextAppearanceSpanBuilder(src);
        return makeSpan(builder);
    }

    /**
     * Rasterizer span skipped since its rasterizer is deprecated since api 21
     */

    public SpanBuilder withStrikethrough() {
        StrikeThroughSpanBuilder builder = new StrikeThroughSpanBuilder();
        return makeSpan(builder);
    }

    public SpanBuilder withStrikeThrough(Parcel src) {
        StrikeThroughSpanBuilder builder = new StrikeThroughSpanBuilder(src);
        return makeSpan(builder);
    }


    public SpanBuilder withSuggestion(Context context, String[] suggestions, int flags) {
        SuggestionSpanBuilder builder = new SuggestionSpanBuilder(context, suggestions, flags);
        return makeSpan(builder);
    }

    public SpanBuilder withSuggestion(Locale locale, String[] suggestions, int flags) {
        SuggestionSpanBuilder builder = new SuggestionSpanBuilder(locale, suggestions, flags);
        return makeSpan(builder);
    }

    public SpanBuilder withSuggestion(Context context, Locale locale, String[] suggestions,
                                      int flags, Class<?> notificationTargetClass) {
        SuggestionSpanBuilder builder = new SuggestionSpanBuilder(context, locale, suggestions,
                flags, notificationTargetClass);
        return makeSpan(builder);
    }

    public SpanBuilder withSuggestion(Parcel src) {
        SuggestionSpanBuilder builder = new SuggestionSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withUnderline() {
        UnderlineSpanBuilder builder = new UnderlineSpanBuilder();
        return makeSpan(builder);
    }

    public SpanBuilder withUnderline(Parcel src) {
        UnderlineSpanBuilder builder = new UnderlineSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withStandardAlignment(Layout.Alignment alignment) {
        AlignmentSpanStandardBuilder builder = new AlignmentSpanStandardBuilder(alignment);
        return makeSpan(builder);
    }

    public SpanBuilder withStandardAlignment(Parcel src) {
        AlignmentSpanStandardBuilder builder = new AlignmentSpanStandardBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withBullet() {
        BulletSpanBuilder builder = new BulletSpanBuilder();
        return makeSpan(builder);
    }

    public SpanBuilder withBullet(int gapWidth) {
        BulletSpanBuilder builder = new BulletSpanBuilder();
        return makeSpan(builder);
    }

    public SpanBuilder withBullet(int gapWidth, int color) {
        BulletSpanBuilder builder = new BulletSpanBuilder(gapWidth, color);
        return makeSpan(builder);
    }

    public SpanBuilder withBullet(Parcel src) {
        BulletSpanBuilder builder = new BulletSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withDrawableMargin(Drawable d) {
        DrawableMarginSpanBuilder builder = new DrawableMarginSpanBuilder(d);
        return makeSpan(builder);
    }

    public SpanBuilder withDrawableMargin(Drawable d, int pad) {
        DrawableMarginSpanBuilder builder = new DrawableMarginSpanBuilder(d, pad);
        return makeSpan(builder);
    }

    public SpanBuilder withIcon(Bitmap b) {
        IconSpanBuilder builder = new IconSpanBuilder(b);
        return makeSpan(builder);
    }

    public SpanBuilder withIcon(Bitmap b, int pad) {
        IconSpanBuilder builder = new IconSpanBuilder(b, pad);
        return makeSpan(builder);
    }

    public SpanBuilder withLeadingStandard(int first, int rest) {
        LeadingMarginStandardSpanBuilder builder = new LeadingMarginStandardSpanBuilder(first, rest);
        return makeSpan(builder);
    }

    public SpanBuilder withLeadingStandard(int every) {
        LeadingMarginStandardSpanBuilder builder = new LeadingMarginStandardSpanBuilder(every);
        return makeSpan(builder);
    }

    public SpanBuilder withLeadingStandard(Parcel src) {
        LeadingMarginStandardSpanBuilder builder = new LeadingMarginStandardSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withQuote() {
        QuoteSpanBuilder builder = new QuoteSpanBuilder();
        return makeSpan(builder);
    }

    public SpanBuilder withQuote(int color) {
        QuoteSpanBuilder builder = new QuoteSpanBuilder(color);
        return makeSpan(builder);
    }

    public SpanBuilder withQuote(Parcel src) {
        QuoteSpanBuilder builder = new QuoteSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpanBuilder withIconMargin(Bitmap b) {
        IconMarginSpanBuilder builder = new IconMarginSpanBuilder(b);
        return makeSpan(builder);
    }

    public SpanBuilder withIconMargin(Bitmap b, int pad) {
        IconMarginSpanBuilder builder = new IconMarginSpanBuilder(b, pad);
        return makeSpan(builder);
    }

    public SpanBuilder withTabStopStandard(int where) {
        TabStopStandardSpanBuilder builder = new TabStopStandardSpanBuilder(where);
        return makeSpan(builder);
    }

    /**
     * Internal methods
     */

    public SpanBuilder withFlag(int flags) {
        this.flags = flags;
        return this;
    }


    public SpanBuilder resetFlags() {
        this.flags = Spanned.SPAN_INCLUSIVE_EXCLUSIVE;
        return this;
    }

    public SpanBuilder index(int startIndex, int endIndex) {
        if (startIndex > endIndex)
            throw new IllegalArgumentException("Start index cannot be higher than end index at: " +
                    "startIndex: " + startIndex + "endIndex: " + endIndex);
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        return this;
    }

    public SpanBuilder resetIndex() {
        this.startIndex = 0;
        this.endIndex = text.length();
        return this;
    }

    public String getText() {
        return text;
    }

    public TextView getTextView() {
        return textView;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getFlags() {
        return flags;
    }

    public SpannableStringBuilder build() {
        return spannableBuilder;
    }

    /**
     * If want to use textView directly with view this method must be invoked at the beginning of a chain
     * in order to retain all functionality
     */
    public SpanBuilder withView(TextView textView) {
        this.textView = textView;
        return this;
    }

    public void buildWithTextView() {
        if (textView == null)
            throw new IllegalStateException("Cannot call buildWithTextView() without calling withView()");
        textView.setText(spannableBuilder);
    }


    private SpanProxy createProxy(int start, int end) {
        return new SpanProxy(this, text, start, end);
    }

    private SpanProxy getDefaultProxy() {
        return createProxy(startIndex, endIndex, flags);
    }

    private SpanProxy createProxy(int start, int end, int flags) {
        return new SpanProxy(this, text, start, end, flags);
    }

    private SpanBuilder makeSpan(SpanTypeBuilder builder) {
        return builder.make(getDefaultProxy());
    }

}