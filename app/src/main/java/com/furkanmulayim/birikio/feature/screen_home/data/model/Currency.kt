package com.furkanmulayim.birikio.feature.screen_home.data.model

data class CurrencyRate(
    val Type: String,
    val Change: Double,
    val Name: String,
    val Buying: Double,
    val Selling: Double,
)

data class TickerItem(
    val code: String,
    val type: String,
    val name: String,
    val buying: Double,
    val selling: Double,
    val change: Double,
)

data class TickersResult(
    val items: List<TickerItem>,
    val updateDate: String,
)