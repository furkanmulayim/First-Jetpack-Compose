package com.furkanmulayim.birikio.core.enums

import com.furkanmulayim.birikio.R

enum class InvestE(val value: String, val drawableRes: Int) {
    DOLLAR("Dolar", R.drawable.svg_money_dollar), EURO(
        "Euro", R.drawable.svg_money_euro
    ),
    GRAM22("Gram Altın ₂₂", R.drawable.svg_money_gram), GRAM24(
        "Gram Altın ₂₄", R.drawable.svg_money_gram
    ),
    CEYREK("Çeyrek Altın", R.drawable.svg_money_ceyrek), YARIM(
        "Yarım Altın", R.drawable.svg_money_yarim
    ),
    TAM("Tam Altın", R.drawable.svg_money_tam), RESAT("Reşat Altın", R.drawable.svg_money_resat);

    companion object {
        fun fromValue(value: String): InvestE? {
            return InvestE.entries.find { it.value == value }
        }
    }
}

enum class SwapImageEnum(val value: String, val drawableRes: Int) {
    DOLLAR("Dolar", R.drawable.svg_money_dollar), EURO(
        "Euro", R.drawable.svg_money_euro
    ),
    TRY("Türk Lirası", R.drawable.svg_money_try);

    companion object {
        fun fromValue(value: String): InvestE? {
            return InvestE.entries.find { it.value == value }
        }
    }
}