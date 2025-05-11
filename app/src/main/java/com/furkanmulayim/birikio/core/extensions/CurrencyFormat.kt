package com.furkanmulayim.birikio.core.extensions

import java.text.NumberFormat
import java.util.Locale

fun String.curencyFormat(): String {
    // Geçerli bir sayı olup olmadığını kontrol et
    val number = this.replace(".", "").replace(",", ".").toDoubleOrNull()
    if (number == null) {
        return "Hesaplanamadı"
    }

    val numberFormat = NumberFormat.getNumberInstance(Locale.forLanguageTag("tr-TR")).apply {
        minimumFractionDigits = 0
        maximumFractionDigits = 2
    }

    // Sayıyı biçimlendir ve '₺' simgesini ekle
    return numberFormat.format(number)
}