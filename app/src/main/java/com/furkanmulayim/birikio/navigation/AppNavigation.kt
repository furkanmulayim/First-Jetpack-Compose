package com.furkanmulayim.birikio.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.furkanmulayim.birikio.feature.screen_home.ui.screen.HomeScreen
import com.furkanmulayim.birikio.feature.screen_onboarding.ui.screen.OnboardingScreen

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

        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(AppScreens.OnboardingScreen.route) {
            OnboardingScreen(
                onStartClicked = {
                    navController.navigate(AppScreens.HomeScreen.route) {
                        popUpTo(AppScreens.OnboardingScreen.route) { inclusive = true }
                    }
                }
            )
        }
    }
}