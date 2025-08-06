package com.furkanmulayim.birikio.core.util

import java.text.NumberFormat
import java.util.Locale

fun String.currencyFormat(symbol: String = "₺"): String {
    val sanitized = this.trim()

    val number = sanitized.toDoubleOrNull() ?: sanitized.replace(",", ".").toDoubleOrNull()
    ?: return "Not Calculated"

    val formatter = NumberFormat.getNumberInstance(Locale.forLanguageTag("tr-TR")).apply {
        minimumFractionDigits = 0
        maximumFractionDigits = 2
    }
    return "${formatter.format(number)} $symbol"
}