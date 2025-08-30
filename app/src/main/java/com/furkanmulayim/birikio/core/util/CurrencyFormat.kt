package com.furkanmulayim.birikio.core.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.birikio.R
import java.text.NumberFormat
import java.util.Locale

@Composable
fun String.currencyFormat(symbol: String = "₺"): String {
    val sanitized = this.trim()

    val number = sanitized.toDoubleOrNull() ?: sanitized.replace(",", ".").toDoubleOrNull()
    ?: return stringResource(R.string.calculateFail)

    val formatter = NumberFormat.getNumberInstance(Locale.forLanguageTag("tr-TR")).apply {
        minimumFractionDigits = 0
        maximumFractionDigits = 2
    }
    return "${formatter.format(number)} $symbol"
}