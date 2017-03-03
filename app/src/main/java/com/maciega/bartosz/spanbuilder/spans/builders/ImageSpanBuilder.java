package com.maciega.bartosz.spanbuilder.spans.builders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.style.ImageSpan;

/**
 * Created by bartoszmaciega on 03/03/17.
 */

public class ImageSpanBuilder extends AbstractSpanTypeBuilder<ImageSpan> {

    public ImageSpanBuilder(Context context, Bitmap b) {
        span = new ImageSpan(context, b);
    }

    public ImageSpanBuilder(Context context, Bitmap b, int verticalAlignment) {
        span = new ImageSpan(context, b, verticalAlignment);
    }

    public ImageSpanBuilder(Drawable drawable) {
        span = new ImageSpan(drawable);
    }

    public ImageSpanBuilder(Drawable drawable, int verticalAlignment) {
        span = new ImageSpan(drawable, verticalAlignment);
    }

    public ImageSpanBuilder(Drawable drawable, String source) {
        span = new ImageSpan(drawable, source);
    }

    public ImageSpanBuilder(Drawable drawable, String source, int verticalAlignment) {
        span = new ImageSpan(drawable, source, verticalAlignment);
    }

    public ImageSpanBuilder(Context context, Uri uri) {
        span = new ImageSpan(context, uri);
    }

    public ImageSpanBuilder(Context context, Uri uri, int verticalAlignment) {
        span = new ImageSpan(context, uri, verticalAlignment);
    }

    public ImageSpanBuilder(Context context, int resourceId) {
        span = new ImageSpan(context, resourceId);
    }

    public ImageSpanBuilder(Context context, int resourceId, int verticalAlignment) {
        span = new ImageSpan(context, resourceId, verticalAlignment);
    }
}
