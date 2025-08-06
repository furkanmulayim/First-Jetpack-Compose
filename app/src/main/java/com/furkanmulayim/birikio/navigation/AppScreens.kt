package com.furkanmulayim.birikio.navigation

sealed class AppScreens(val route: String) {

    data object HomeScreen : AppScreens("home")

    data object OnboardingScreen : AppScreens("onboarding")
}