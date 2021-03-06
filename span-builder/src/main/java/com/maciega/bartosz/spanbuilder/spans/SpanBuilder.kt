package com.maciega.bartosz.spanbuilder.spans

import android.annotation.TargetApi
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Bitmap
import android.graphics.MaskFilter
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.support.annotation.ColorInt
import android.text.Layout
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.AbsoluteSizeSpan
import android.text.style.AlignmentSpan
import android.text.style.BackgroundColorSpan
import android.text.style.BulletSpan
import android.text.style.ClickableSpan
import android.text.style.DrawableMarginSpan
import android.text.style.ForegroundColorSpan
import android.text.style.IconMarginSpan
import android.text.style.ImageSpan
import android.text.style.LeadingMarginSpan
import android.text.style.LocaleSpan
import android.text.style.MaskFilterSpan
import android.text.style.QuoteSpan
import android.text.style.RelativeSizeSpan
import android.text.style.ScaleXSpan
import android.text.style.StrikethroughSpan
import android.text.style.StyleSpan
import android.text.style.SuggestionSpan
import android.text.style.TabStopSpan
import android.text.style.TextAppearanceSpan
import android.text.style.TypefaceSpan
import android.text.style.URLSpan
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.TextView
import java.util.Locale

const val ZERO_START_INDEX = 0
const val DEFAULT_SPAN_FLAG = Spanned.SPAN_INCLUSIVE_EXCLUSIVE

inline fun TextView.withSpan(text: String, flags: Int = DEFAULT_SPAN_FLAG, buildFunc: SpanBuilder.(TextView) -> Unit) {
  val builder = SpanBuilder(text, flags)
  buildFunc.invoke(builder, this)
  this.text = builder.build()
}

class SpanBuilder constructor(text: String, private val initialFlags: Int) {

  constructor(text: String, flags: Int = DEFAULT_SPAN_FLAG, buildFunc: SpanBuilder.() -> Unit) : this(text, flags) {
    buildFunc.invoke(this)
  }

  private val innerSpanBuilder: SpannableStringBuilder = SpannableStringBuilder(text)
  private val textLength = text.length

  fun backgroundColor(@ColorInt color: Int, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(BackgroundColorSpan(color), start, end, flags)
  }

  fun foregroundColor(@ColorInt color: Int, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(ForegroundColorSpan(color), start, end, flags)
  }

  fun clickable(textView: TextView, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags, listener: (View) -> Unit) {
    val clickableSpan = object : ClickableSpan() {
      override fun onClick(widget: View) {
        listener.invoke(widget)
      }
    }
    innerSpanBuilder.setSpan(clickableSpan, start, end, flags)
    textView.movementMethod = LinkMovementMethod.getInstance()
  }

  fun url(url: String, textView: TextView, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(URLSpan(url), start, end, flags)
    textView.movementMethod = LinkMovementMethod.getInstance()
  }

  fun mask(filter: MaskFilter, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(MaskFilterSpan(filter), start, end, flags)
  }

  fun absoluteSize(size: Int, dip: Boolean = false, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(AbsoluteSizeSpan(size, dip), start, end, flags)
  }

  @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
  fun locale(locale: Locale, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(LocaleSpan(locale), start, end, flags)
  }

  fun relative(proportion: Float, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(RelativeSizeSpan(proportion), start, end, flags)
  }

  fun image(context: Context, bitmap: Bitmap, verticalAlignment: Int? = null, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    val imageSpan = if (verticalAlignment != null) ImageSpan(context, bitmap, verticalAlignment) else ImageSpan(context, bitmap)
    innerSpanBuilder.setSpan(imageSpan, start, end, flags)
  }

  fun image(context: Context, uri: Uri, verticalAlignment: Int? = null, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    val imageSpan = if (verticalAlignment != null) ImageSpan(context, uri, verticalAlignment) else ImageSpan(context, uri)
    innerSpanBuilder.setSpan(imageSpan, start, end, flags)
  }

  fun image(context: Context, resourceId: Int, verticalAlignment: Int? = null, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    val imageSpan = if (verticalAlignment != null) ImageSpan(context, resourceId, verticalAlignment) else ImageSpan(context, resourceId)
    innerSpanBuilder.setSpan(imageSpan, start, end, flags)
  }

  fun image(drawable: Drawable, source: String? = null, verticalAlignment: Int? = null, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    val imageSpan = when (source) {
      null -> if (verticalAlignment == null) ImageSpan(drawable) else ImageSpan(drawable, verticalAlignment)
      else -> if (verticalAlignment == null) ImageSpan(drawable, source) else ImageSpan(drawable, source, verticalAlignment)
    }
    innerSpanBuilder.setSpan(imageSpan, start, end, flags)
  }

  fun scaleX(proportion: Float, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(ScaleXSpan(proportion), start, end, flags)
  }

  fun style(style: Int, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(StyleSpan(style), start, end, flags)
  }

  fun typeface(family: String, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(TypefaceSpan(family), start, end, flags)
  }

  fun textAppearance(context: Context, appearance: Int, colorList: Int = -1, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(TextAppearanceSpan(context, appearance, colorList), start, end, flags)
  }

  fun textAppearance(
    family: String,
    style: Int,
    size: Int,
    color: ColorStateList,
    linkColor: ColorStateList,
    start: Int = ZERO_START_INDEX,
    end: Int = textLength,
    flags: Int = initialFlags
  ) {
    innerSpanBuilder.setSpan(TextAppearanceSpan(family, style, size, color, linkColor), start, end, flags)
  }

  fun strikeThrough(start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(StrikethroughSpan(), start, end, flags)
  }

  fun suggestion(context: Context, suggestions: Array<String>, spanFlags: Int, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(SuggestionSpan(context, suggestions, spanFlags), start, end, flags)
  }

  fun suggestion(locale: Locale, suggestions: Array<String>, spanFlags: Int, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(SuggestionSpan(locale, suggestions, spanFlags), start, end, flags)
  }

  fun suggestion(
    context: Context? = null,
    locale: Locale? = null,
    suggestions: Array<String>,
    spanFlags: Int,
    notificationTargetClass: Class<Any>? = null,
    start: Int = ZERO_START_INDEX,
    end: Int = textLength,
    flags: Int = initialFlags
  ) {
    innerSpanBuilder.setSpan(SuggestionSpan(context, locale, suggestions, spanFlags, notificationTargetClass), start, end, flags)
  }

  fun underline(start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(UnderlineSpan(), start, end, flags)
  }

  fun standardAlignment(alignment: Layout.Alignment, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(AlignmentSpan.Standard(alignment), start, end, flags)
  }

  fun bullet(gapWidth: Int? = null, @ColorInt color: Int? = null, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    val bulletSpan = when {
      gapWidth != null -> if (color != null) BulletSpan(gapWidth, color) else BulletSpan(gapWidth)
      color == null -> BulletSpan()
      else -> throw InvalidSpanArgumentsException("Invalid arguments, gapWidth cannot be null when color is not null")
    }
    innerSpanBuilder.setSpan(bulletSpan, start, end, flags)
  }

  fun drawableMargin(drawable: Drawable, padding: Int? = null, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    val drawableMarginSpan = if (padding == null) {
      DrawableMarginSpan(drawable)
    } else {
      DrawableMarginSpan(drawable, padding)
    }
    innerSpanBuilder.setSpan(drawableMarginSpan, start, end, flags)
  }

  fun iconMargin(bitmap: Bitmap, padding: Int? = null, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    val iconMarginSpan = if (padding == null) {
      IconMarginSpan(bitmap)
    } else {
      IconMarginSpan(bitmap, padding)
    }
    innerSpanBuilder.setSpan(iconMarginSpan, start, end, flags)
  }

  fun leadingMarginStandard(first: Int? = null, rest: Int? = null, every: Int? = null, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    val leadingMarginSpan = when {
      every != null -> LeadingMarginSpan.Standard(every)
      rest != null && first != null -> LeadingMarginSpan.Standard(first, rest)
      else -> throw InvalidSpanArgumentsException("Invalid arguments, must to declare every, or both first and rest")
    }
    innerSpanBuilder.setSpan(leadingMarginSpan, start, end, flags)
  }

  fun quoteSpan(@ColorInt color: Int? = null, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    val quoteSpan = when (color) {
      null -> QuoteSpan()
      else -> QuoteSpan(color)
    }
    innerSpanBuilder.setSpan(quoteSpan, start, end, flags)
  }

  fun tabStopStandard(offset: Int, start: Int = ZERO_START_INDEX, end: Int = textLength, flags: Int = initialFlags) {
    innerSpanBuilder.setSpan(TabStopSpan.Standard(offset), start, end, flags)
  }

  fun build() = innerSpanBuilder
}