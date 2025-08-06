package com.furkanmulayim.birikio.nav

sealed class AppScreens(val route: String) {

    data object HomeScreen : AppScreens("home")

    data object OnboardingScreen : AppScreens("onboarding")
}