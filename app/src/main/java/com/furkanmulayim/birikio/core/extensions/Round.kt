package com.furkanmulayim.birikio.core.extensions

import java.math.BigDecimal
import java.math.RoundingMode

fun Double.round(decimals: Int): Double =
    BigDecimal(this).setScale(decimals, RoundingMode.HALF_UP).toDouble()