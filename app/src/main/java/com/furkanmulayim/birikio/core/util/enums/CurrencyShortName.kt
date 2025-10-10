package com.furkanmulayim.birikio.core.util.enums

import com.furkanmulayim.birikio.R

enum class CurrencyShortName(val id: String, val displayName: String, val image: Int) {
    USD(id = "USD", "Dolar", R.drawable.money_dollar),
    EUR(id = "EUR", "Euro", R.drawable.money_euro),
    GR(id = "GRA", "Gram Altın", R.drawable.money_gram),
    CYR(id = "CEYREKALTIN", "Çeyrek Altın", R.drawable.money_ceyrek),
    YRM(id = "YARIMALTIN", "Yarım Altın", R.drawable.money_yarim),
    TAM(id = "TAMALTIN", "Tam Altın", R.drawable.money_tam),
    TL(id = "TL", "Türk Lirası", R.drawable.money_try);

    companion object {
        fun getLongName(shortName: String): String =
            entries.find { it.name == shortName }?.displayName ?: ""

        fun getShortName(longName: String): String =
            entries.find { it.displayName == longName }?.name ?: ""

        fun getImage(shortName: String): Int =
            entries.find { it.id == shortName }?.image ?: R.drawable.money_error

        fun isAllowed(code: String): Boolean {
            return entries.any { it.id == code }
        }

        fun editDisplayName(code: String): String {
            return entries.find { it.id == code }?.displayName ?: code
        }
    }
}