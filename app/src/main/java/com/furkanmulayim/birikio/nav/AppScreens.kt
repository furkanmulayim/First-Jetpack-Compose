package com.furkanmulayim.birikio.nav

sealed class AppScreens(val route: String) {

    data object InvestingScreen : AppScreens("investing")

    data object ExchangeRateScreen : AppScreens("exchange")
}