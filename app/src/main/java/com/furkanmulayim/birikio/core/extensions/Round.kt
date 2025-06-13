package com.furkanmulayim.birikio.core.extensions

import java.math.RoundingMode
import java.math.BigDecimal

fun Double.Round(decimals: Int): Double =
    BigDecimal(this).setScale(decimals, RoundingMode.HALF_UP).toDouble()