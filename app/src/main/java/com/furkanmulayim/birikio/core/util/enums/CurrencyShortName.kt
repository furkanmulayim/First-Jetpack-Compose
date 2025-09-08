package com.furkanmulayim.birikio.core.util.enums

import com.furkanmulayim.birikio.R

enum class CurrencyShortName(val displayName: String, val image: Int) {
    USD("Dolar", R.drawable.money_dollar),
    EUR("Euro", R.drawable.money_euro),
    GR("Gram Altın", R.drawable.money_gram),
    CYR("Çeyrek Altın", R.drawable.money_ceyrek),
    YRM("Yarım Altın", R.drawable.money_yarim),
    TAM("Tam Altın", R.drawable.money_tam),
    TL("Türk Lirası", R.drawable.money_try);

    companion object {
        fun getLongName(shortName: String): String =
            entries.find { it.name == shortName }?.displayName ?: ""

        fun getShortName(longName: String): String =
            entries.find { it.displayName == longName }?.name ?: ""

        fun getImage(shortName: String): Int =
            entries.find { it.name == shortName }?.image ?: R.drawable.money_error
    }
}