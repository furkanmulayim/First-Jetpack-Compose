package com.furkanmulayim.golden.core.extensions

import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.enums.InvestImageEnum

fun String.getInvestNameToImage(): Int {
    return InvestImageEnum.entries.find { it.value == this }?.drawableRes
        ?: R.drawable.svg_money_error
}