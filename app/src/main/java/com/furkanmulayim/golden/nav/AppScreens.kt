package com.furkanmulayim.golden.nav

sealed class AppScreens(val route: String) {

    data object HomeScreen : AppScreens("home")
    data object InvestingScreen : AppScreens("investing")
    data object IbanScreen : AppScreens("ibans") {
        fun createRoute() = "route"

    }
}