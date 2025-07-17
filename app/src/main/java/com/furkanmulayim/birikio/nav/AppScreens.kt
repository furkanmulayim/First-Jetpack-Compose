package com.furkanmulayim.birikio.nav

sealed class AppScreens(val route: String) {

    data object HomeScreen : AppScreens("home")
    data object InvestingScreen : AppScreens("investing")
    data object IbanScreen : AppScreens("ibans") {
        fun createRoute() = "route"
    }

    data object ExchangeRateScreen : AppScreens("exchange")
}