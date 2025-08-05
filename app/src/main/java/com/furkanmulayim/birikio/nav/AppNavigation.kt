package com.furkanmulayim.birikio.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.furkanmulayim.birikio.ui.screen_investing.view.InvestingScreen
import com.furkanmulayim.birikio.ui.screen_onboarding.view.OnboardingScreen

// AppNavigation.kt
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController, startDestination = startDestination
    ) {

        composable(AppScreens.InvestingScreen.route) {
            InvestingScreen(navController)
        }
        composable(AppScreens.OnboardingScreen.route) {
            OnboardingScreen(
                onStartClicked = {
                    navController.navigate(AppScreens.InvestingScreen.route) {
                        popUpTo(AppScreens.OnboardingScreen.route) { inclusive = true }
                    }
                }
            )
        }
    }
}