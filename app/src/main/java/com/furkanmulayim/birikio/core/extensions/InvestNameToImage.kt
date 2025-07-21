package com.furkanmulayim.birikio.core.extensions

import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.enums.InvestE
import com.furkanmulayim.birikio.core.enums.SwapImageEnum

fun String.getInvestNameToImage(): Int {
    return InvestE.entries.find { it.value == this }?.drawableRes
        ?: R.drawable.svg_money_error
}

fun String.getSwapNameToImage(): Int {
    return SwapImageEnum.entries.find { it.value == this }?.drawableRes
        ?: R.drawable.svg_money_error
}



