package com.furkanmulayim.birikio.core.util

import com.furkanmulayim.birikio.feature.screen_home.data.model.AllMoneys
import com.furkanmulayim.birikio.feature.screen_home.data.model.Currency


fun calculateAllMoneys(curr: List<Currency>): AllMoneys {
    val usdPrice = curr.find { it.code == "USD" }?.buying
    val eurPrice = curr.find { it.code == "EUR" }?.buying
    val gramPrice = curr.find { it.code == "GRA" }?.buying

    // Gramlar
    val goldQuarter = 1.79183
    val goldHalf = 3.58367
    val goldFull = 7.12858
    val goldResat = 7.1535

    // Saflık oranı
    val purity22 = 0.916

    val goldGrams24 = gramPrice ?: 0.0
    val goldGrams22 = goldGrams24 * purity22

    return AllMoneys(
        usd = usdPrice?.round(2) ?: 0.0,
        eur = eurPrice?.round(2) ?: 0.0,
        grams24 = goldGrams24.toInt(),
        grams22 = goldGrams22.toInt(),
        quart = (goldGrams22 * goldQuarter).toInt(),
        half = (goldGrams22 * goldHalf).toInt(),
        full = (goldGrams22 * goldFull).toInt(),
        resat = (goldGrams22 * goldResat).toInt()
    )
}