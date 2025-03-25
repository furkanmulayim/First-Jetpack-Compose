package com.furkanmulayim.golden.core.enums

import com.furkanmulayim.golden.R

enum class InvestImageEnum(val value: String, val drawableRes: Int) {
    DOLLAR("Dolar", R.drawable.png_invest_dollar), EURO(
        "Euro", R.drawable.png_invest_euro
    ),
    GRAM22("Gram Altın ₂₂", R.drawable.png_invest_gold_22), GRAM24(
        "Gram Altın ₂₄", R.drawable.png_invest_gold_24
    ),
    CEYREK("Çeyrek Altın", R.drawable.png_invest_gold_ceyrek), YARIM(
        "Yarım Altın", R.drawable.png_invest_gold_yarim
    ),
    TAM("Tam Altın", R.drawable.png_invest_gold_tam), RESAT(
        "Reşat Altın", R.drawable.png_invest_gold_resat
    ),
}