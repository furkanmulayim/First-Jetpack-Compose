package com.furkanmulayim.birikio.core.extensions

import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.enums.WalletCategoryEnum

fun String.getWalletNameToImage(): Int {
    return WalletCategoryEnum.entries.find { it.value == this }?.drawableRes
        ?: R.drawable.svg_money_error
}


