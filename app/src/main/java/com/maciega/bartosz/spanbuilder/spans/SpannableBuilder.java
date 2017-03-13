package com.maciega.bartosz.spanbuilder.spans;

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

import com.maciega.bartosz.spanbuilder.spans.builders.AbsoluteSizeSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.AlignmentSpanStandardBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.BackgroundColorSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.BulletSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.ClickableSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.DrawableMarginSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.ForegroundColorSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.IconMarginSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.IconSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.ImageSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.LeadingMarginStandardSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.LocaleSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.MaskFilterSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.QuoteSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.RelativeSizeSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.ScaleXSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.StrikeThroughSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.StyleSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.SuggestionSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.TabStopStandardSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.TextAppearanceSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.TypeFaceSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.UnderlineSpanBuilder;
import com.maciega.bartosz.spanbuilder.spans.builders.UrlSpanBuilder;

import java.util.Locale;

/**
 * Created by bartoszmaciega on 28/02/17.
 */

/**
 * Things to do:
 * - add span flags
 * - route spans to helper classes( separated by superclasses)
 * - rethink if should remove constructors with parcel
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
        return makeSpan(builder);
    }

    public SpannableBuilder withBackgroundColor(Parcel src) {
        BackgroundColorSpanBuilder builder = new BackgroundColorSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withForegroundColor(int color) {
        ForegroundColorSpanBuilder builder = new ForegroundColorSpanBuilder(color);
        return makeSpan(builder);
    }

    public SpannableBuilder withForegroundColor(Parcel src) {
        ForegroundColorSpanBuilder builder = new ForegroundColorSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withClickable(View.OnClickListener listener) {
        ClickableSpanBuilder builder = new ClickableSpanBuilder(listener);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return makeSpan(builder);
    }

    public SpannableBuilder withUrl(String url) {
        UrlSpanBuilder builder = new UrlSpanBuilder(url);
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return makeSpan(builder);
    }

    public SpannableBuilder withMask(MaskFilter mask) {
        MaskFilterSpanBuilder builder = new MaskFilterSpanBuilder(mask);
        return makeSpan(builder);
    }

    public SpannableBuilder withAbsoluteSize(int size) {
        AbsoluteSizeSpanBuilder builder = new AbsoluteSizeSpanBuilder(size, false);
        return makeSpan(builder);
    }

    public SpannableBuilder withAbsoluteSize(int size, boolean dip) {
        AbsoluteSizeSpanBuilder builder = new AbsoluteSizeSpanBuilder(size, dip);
        return makeSpan(builder);
    }

    public SpannableBuilder withAbsoluteSize(Parcel src) {
        AbsoluteSizeSpanBuilder builder = new AbsoluteSizeSpanBuilder(src);
        return makeSpan(builder);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public SpannableBuilder withLocale(Locale locale) {
        LocaleSpanBuilder builder = new LocaleSpanBuilder(locale);
        return makeSpan(builder);
    }

    @TargetApi(Build.VERSION_CODES.N)
    public SpannableBuilder withLocale(LocaleList localeList) {
        LocaleSpanBuilder builder = new LocaleSpanBuilder(localeList);
        return makeSpan(builder);
    }

    public SpannableBuilder withLocale(Parcel src) {
        LocaleSpanBuilder builder = new LocaleSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withRelative(float proportion) {
        RelativeSizeSpanBuilder builder = new RelativeSizeSpanBuilder(proportion);
        return makeSpan(builder);
    }

    public SpannableBuilder withRelative(Parcel src) {
        RelativeSizeSpanBuilder builder = new RelativeSizeSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withImage(Context context, Bitmap bitmap) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, bitmap);
        return makeSpan(builder);
    }

    public SpannableBuilder withImage(Context context, Bitmap bitmap, int verticalAlignment) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, bitmap, verticalAlignment);
        return makeSpan(builder);
    }

    public SpannableBuilder withImage(Drawable drawable) {
        ImageSpanBuilder builder = new ImageSpanBuilder(drawable);
        return makeSpan(builder);
    }

    public SpannableBuilder withImage(Drawable drawable, String source) {
        ImageSpanBuilder builder = new ImageSpanBuilder(drawable, source);
        return makeSpan(builder);
    }

    public SpannableBuilder withImage(Drawable drawable, int verticalAlignment) {
        ImageSpanBuilder builder = new ImageSpanBuilder(drawable, verticalAlignment);
        return makeSpan(builder);
    }

    public SpannableBuilder withImage(Drawable drawable, String source, int verticalAlignment) {
        ImageSpanBuilder builder = new ImageSpanBuilder(drawable, source, verticalAlignment);
        return makeSpan(builder);
    }

    public SpannableBuilder withImage(Context context, Uri uri) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, uri);
        return makeSpan(builder);
    }

    public SpannableBuilder withImage(Context context, Uri uri, int verticalAlignment) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, uri, verticalAlignment);
        return makeSpan(builder);
    }

    public SpannableBuilder withImage(Context context, int resourceId) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, resourceId);
        return makeSpan(builder);
    }

    public SpannableBuilder withImage(Context context, int resourceId, int verticalAlignment) {
        ImageSpanBuilder builder = new ImageSpanBuilder(context, resourceId, verticalAlignment);
        return makeSpan(builder);
    }

    public SpannableBuilder withXScale(float proportion) {
        ScaleXSpanBuilder builder = new ScaleXSpanBuilder(proportion);
        return makeSpan(builder);
    }

    public SpannableBuilder withXScale(Parcel src) {
        ScaleXSpanBuilder builder = new ScaleXSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withStyle(int style) {
        StyleSpanBuilder builder = new StyleSpanBuilder(style);
        return makeSpan(builder);
    }

    public SpannableBuilder withStyle(Parcel src) {
        StyleSpanBuilder builder = new StyleSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withTypeface(String family) {
        TypeFaceSpanBuilder builder = new TypeFaceSpanBuilder(family);
        return makeSpan(builder);
    }

    public SpannableBuilder withTypeface(Parcel src) {
        TypeFaceSpanBuilder builder = new TypeFaceSpanBuilder(src);
        return makeSpan(builder);
    }


    /**
     * Subscript and superscript span skipped intentionally , test its behavior in future
     */


    public SpannableBuilder withTextAppearance(Context context, int appearance) {
        TextAppearanceSpanBuilder builder = new TextAppearanceSpanBuilder(context, appearance);
        return makeSpan(builder);
    }

    public SpannableBuilder withTextAppearance(Context context, int appearance, int colorList) {
        TextAppearanceSpanBuilder builder = new TextAppearanceSpanBuilder(context, appearance, colorList);
        return makeSpan(builder);
    }

    public SpannableBuilder withTextAppearance(String family, int style, int size, ColorStateList color, ColorStateList linkColor) {
        TextAppearanceSpanBuilder builder = new TextAppearanceSpanBuilder(family, style, size, color, linkColor);
        return makeSpan(builder);
    }

    public SpannableBuilder withTextAppearance(Parcel src) {
        TextAppearanceSpanBuilder builder = new TextAppearanceSpanBuilder(src);
        return makeSpan(builder);
    }

    /**
     * Rasterizer span skipped since its rasterizer is deprecated since api 21
     */

    public SpannableBuilder withStrikethrough() {
        StrikeThroughSpanBuilder builder = new StrikeThroughSpanBuilder();
        return makeSpan(builder);
    }

    public SpannableBuilder withStrikeThrough(Parcel src) {
        StrikeThroughSpanBuilder builder = new StrikeThroughSpanBuilder(src);
        return makeSpan(builder);
    }


    public SpannableBuilder withSuggestion(Context context, String[] suggestions, int flags) {
        SuggestionSpanBuilder builder = new SuggestionSpanBuilder(context, suggestions, flags);
        return makeSpan(builder);
    }

    public SpannableBuilder withSuggestion(Locale locale, String[] suggestions, int flags) {
        SuggestionSpanBuilder builder = new SuggestionSpanBuilder(locale, suggestions, flags);
        return makeSpan(builder);
    }

    public SpannableBuilder withSuggestion(Context context, Locale locale, String[] suggestions,
                                           int flags, Class<?> notificationTargetClass) {
        SuggestionSpanBuilder builder = new SuggestionSpanBuilder(context, locale, suggestions,
                flags, notificationTargetClass);
        return makeSpan(builder);
    }

    public SpannableBuilder withSuggestion(Parcel src) {
        SuggestionSpanBuilder builder = new SuggestionSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withUnderline() {
        UnderlineSpanBuilder builder = new UnderlineSpanBuilder();
        return makeSpan(builder);
    }

    public SpannableBuilder withUnderline(Parcel src) {
        UnderlineSpanBuilder builder = new UnderlineSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withStandardAlignment(Layout.Alignment alignment) {
        AlignmentSpanStandardBuilder builder = new AlignmentSpanStandardBuilder(alignment);
        return makeSpan(builder);
    }

    public SpannableBuilder withStandardAlignment(Parcel src) {
        AlignmentSpanStandardBuilder builder = new AlignmentSpanStandardBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withBullet() {
        BulletSpanBuilder builder = new BulletSpanBuilder();
        return makeSpan(builder);
    }

    public SpannableBuilder withBullet(int gapWidth) {
        BulletSpanBuilder builder = new BulletSpanBuilder();
        return makeSpan(builder);
    }

    public SpannableBuilder withBullet(int gapWidth, int color) {
        BulletSpanBuilder builder = new BulletSpanBuilder(gapWidth, color);
        return makeSpan(builder);
    }

    public SpannableBuilder withBullet(Parcel src) {
        BulletSpanBuilder builder = new BulletSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withDrawableMargin(Drawable d) {
        DrawableMarginSpanBuilder builder = new DrawableMarginSpanBuilder(d);
        return makeSpan(builder);
    }

    public SpannableBuilder withDrawableMargin(Drawable d, int pad) {
        DrawableMarginSpanBuilder builder = new DrawableMarginSpanBuilder(d, pad);
        return makeSpan(builder);
    }

    public SpannableBuilder withIcon(Bitmap b) {
        IconSpanBuilder builder = new IconSpanBuilder(b);
        return makeSpan(builder);
    }

    public SpannableBuilder withIcon(Bitmap b, int pad) {
        IconSpanBuilder builder = new IconSpanBuilder(b, pad);
        return makeSpan(builder);
    }

    public SpannableBuilder withLeadingStandard(int first, int rest) {
        LeadingMarginStandardSpanBuilder builder = new LeadingMarginStandardSpanBuilder(first, rest);
        return makeSpan(builder);
    }

    public SpannableBuilder withLeadingStandard(int every) {
        LeadingMarginStandardSpanBuilder builder = new LeadingMarginStandardSpanBuilder(every);
        return makeSpan(builder);
    }

    public SpannableBuilder withLeadingStandard(Parcel src) {
        LeadingMarginStandardSpanBuilder builder = new LeadingMarginStandardSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withQuote() {
        QuoteSpanBuilder builder = new QuoteSpanBuilder();
        return makeSpan(builder);
    }

    public SpannableBuilder withQuote(int color) {
        QuoteSpanBuilder builder = new QuoteSpanBuilder(color);
        return makeSpan(builder);
    }

    public SpannableBuilder withQuote(Parcel src) {
        QuoteSpanBuilder builder = new QuoteSpanBuilder(src);
        return makeSpan(builder);
    }

    public SpannableBuilder withIconMargin(Bitmap b) {
        IconMarginSpanBuilder builder = new IconMarginSpanBuilder(b);
        return makeSpan(builder);
    }

    public SpannableBuilder withIconMargin(Bitmap b, int pad) {
        IconMarginSpanBuilder builder = new IconMarginSpanBuilder(b, pad);
        return makeSpan(builder);
    }

    public SpannableBuilder withTabStopStandard(int where) {
        TabStopStandardSpanBuilder builder = new TabStopStandardSpanBuilder(where);
        return makeSpan(builder);
    }

    /**
     * Internal methods
     */

    public SpannableBuilder withFlag(int flags) {
        this.flags = flags;
        return this;
    }


    public SpannableBuilder resetFlags() {
        this.flags = Spanned.SPAN_INCLUSIVE_EXCLUSIVE;
        return this;
    }

    public SpannableBuilder index(int startIndex, int endIndex) {
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


    private SpanProxy createProxy(int start, int end) {
        return new SpanProxy(this, text, start, end);
    }

    private SpanProxy getDefaultProxy() {
        return createProxy(startIndex, endIndex, flags);
    }

    private SpanProxy createProxy(int start, int end, int flags) {
        return new SpanProxy(this, text, start, end, flags);
    }

    private SpannableBuilder makeSpan(SpanTypeBuilder builder) {
        return builder.make(getDefaultProxy());
    }

}