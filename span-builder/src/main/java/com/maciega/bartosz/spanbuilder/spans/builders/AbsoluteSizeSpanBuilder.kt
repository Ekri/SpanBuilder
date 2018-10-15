package com.maciega.bartosz.spanbuilder.spans.builders

import android.os.Parcel
import android.text.style.AbsoluteSizeSpan

/**
 * Created by bartoszmaciega on 03/03/17.
 */

class AbsoluteSizeSpanBuilder : AbstractSpanTypeBuilder<AbsoluteSizeSpan> {

  constructor(size: Int, dip: Boolean) {
    span = AbsoluteSizeSpan(size, dip)
  }

  constructor(parcel: Parcel) {
    span = AbsoluteSizeSpan(parcel)
  }

}
