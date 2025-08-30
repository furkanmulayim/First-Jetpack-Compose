package com.furkanmulayim.birikio.navigation

object Routes {
    const val ONBOARDING = "onboarding"
    const val HOME = "home"
    const val BUYSOLD = "buysold"
    const val RECENT = "recent"
    const val RATE_EXCHANGE = "exchange"
    const val WALLET = "wallet"
    const val GOALS = "goals"
    const val SETTINGS = "settings"
    const val PROFILE = "profile"
}

sealed class Screens(val route: String) {
    data object Onboarding : Screens(Routes.ONBOARDING)
    data object Home : Screens(Routes.HOME)
    data object BuySold : Screens(Routes.BUYSOLD)
    data object Recents : Screens(Routes.RECENT)
    data object RateExchange : Screens(Routes.RATE_EXCHANGE)
    data object Wallet : Screens(Routes.WALLET)
    data object Goals : Screens(Routes.GOALS)
    data object Settings : Screens(Routes.SETTINGS)
    data object Profile : Screens(Routes.PROFILE)
}