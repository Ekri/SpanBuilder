package com.maciega.bartosz.spanbuilder.spans.builders;

import android.os.Parcel;
import android.text.Layout;
import android.text.style.AlignmentSpan;

/**
 * Created by bartoszmaciega on 08/03/17.
 */

public class AlignmentSpanStandardBuilder extends AbstractSpanTypeBuilder<AlignmentSpan.Standard> {

    public AlignmentSpanStandardBuilder(Layout.Alignment alignment) {
        span = new AlignmentSpan.Standard(alignment);
    }

    public AlignmentSpanStandardBuilder(Parcel src) {
        span = new AlignmentSpan.Standard(src);
    }
}
