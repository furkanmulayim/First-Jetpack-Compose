package com.furkanmulayim.birikio.core.extensions

import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.enums.WalletExpenseCategoryEnum
import com.furkanmulayim.birikio.core.enums.WalletIncomeCategoryEnum

fun String.getWalletNameToImage(isBuyed: Boolean): Int {
    if (isBuyed) {
        return WalletIncomeCategoryEnum.entries.find { it.value == this }?.drawableRes
            ?: R.drawable.svg_money_error
    } else {
        return WalletExpenseCategoryEnum.entries.find { it.value == this }?.drawableRes
            ?: R.drawable.svg_money_error
    }

}


