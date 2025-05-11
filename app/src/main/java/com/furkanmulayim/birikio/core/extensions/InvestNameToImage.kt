package com.furkanmulayim.birikio.core.extensions

import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.enums.InvestImageEnum

fun String.getInvestNameToImage(): Int {
    return InvestImageEnum.entries.find { it.value == this }?.drawableRes
        ?: R.drawable.svg_money_error
}