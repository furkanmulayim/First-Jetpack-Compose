package com.furkanmulayim.birikio.core.extensions

import com.furkanmulayim.birikio.model.AllMoneys
import com.furkanmulayim.birikio.model.Currency


fun calculateAllMoneys(curr: List<Currency>): AllMoneys {
    val usdPrice = curr.find { it.code == "USD" }?.buying
    val eurPrice = curr.find { it.code == "EUR" }?.buying
    val gramPrice = curr.find { it.code == "GRA" }?.buying

    // Gramlar
    val ceyrekGr = 1.79183
    val yarimGr = 3.58367
    val tamGr = 7.12858
    val resatGr = 7.1535

    // Saflık oranı
    val saflik22 = 0.916

    val gramAltin24 = gramPrice ?: 0.0
    val gramAltin22 = gramAltin24 * saflik22

    return AllMoneys(
        usd = usdPrice?.Round(2) ?: 0.0,
        eur = eurPrice?.Round(2) ?: 0.0,
        gram24 = gramAltin24.toInt(),
        gram22 = gramAltin22.toInt(),
        ceyrek = (gramAltin22 * ceyrekGr).toInt(),
        yarim = (gramAltin22 * yarimGr).toInt(),
        tam = (gramAltin22 * tamGr).toInt(),
        resat = (gramAltin22 * resatGr).toInt()
    )
}