package com.furkanmulayim.golden.navigation

sealed class AppScreens(val route: String) {

    data object HomeScreen : AppScreens("home")
    data object InvestingScreen : AppScreens("investing") {
        fun go() = "investing/"
    }
}