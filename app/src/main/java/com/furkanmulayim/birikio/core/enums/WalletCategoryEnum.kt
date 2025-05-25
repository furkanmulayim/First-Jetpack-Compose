package com.furkanmulayim.birikio.core.enums

import com.furkanmulayim.birikio.R

enum class WalletIncomeCategoryEnum(val value: String, val drawableRes: Int) {
    MAAS("Maaş", R.drawable.svg_wallet_maas), GELIR(
        "Gelir", R.drawable.svg_wallet_gelir
    ),
    ALACAK("Alacak", R.drawable.svg_wallet_alacak), DIGER("Diğer", R.drawable.svg_wallet_diger);

    companion object {
        fun fromValue(value: String): WalletIncomeCategoryEnum? {
            return WalletIncomeCategoryEnum.entries.find { it.value == value }
        }
    }
}

enum class WalletExpenseCategoryEnum(val value: String, val drawableRes: Int) {
    ALISVERIS("Alışveriş", R.drawable.svg_wallet_alisveris), GIDER(
        "Gider", R.drawable.svg_wallet_gider
    ),
    BORC("Borç", R.drawable.svg_wallet_borc), DIGER("Diğer", R.drawable.svg_wallet_diger);

    companion object {
        fun fromValue(value: String): WalletExpenseCategoryEnum? {
            return WalletExpenseCategoryEnum.entries.find { it.value == value }
        }
    }
}



