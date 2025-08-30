package com.furkanmulayim.birikio.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.furkanmulayim.birikio.feature.screen_buy_sold.ui.screen.BuySoldScreen
import com.furkanmulayim.birikio.feature.screen_goals.ui.screen.GoalsScreen
import com.furkanmulayim.birikio.feature.screen_home.ui.screen.HomeScreen
import com.furkanmulayim.birikio.feature.screen_onboarding.ui.screen.OnboardingScreen
import com.furkanmulayim.birikio.feature.screen_profile.ui.screen.ProfileScreen
import com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.screen.RateExchangeScreen
import com.furkanmulayim.birikio.feature.screen_recents.ui.screen.RecentsScreen
import com.furkanmulayim.birikio.feature.screen_settings.ui.screen.SettingsScreen
import com.furkanmulayim.birikio.feature.screen_wallet.ui.screen.WalletScreen

// AppNavigation.kt
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(
    navController: NavHostController, startDestination: String
) {
    NavHost(
        navController = navController, startDestination = startDestination
    ) {


        composable(Screens.Onboarding.route) {
            OnboardingScreen(
                onStartClicked = {
                    navController.navigate(Screens.Home.route) {
                        popUpTo(Screens.Onboarding.route) { inclusive = true }
                    }
                })
        }
        composable(Screens.Home.route) {
            HomeScreen(navController)
        }
        composable(Screens.BuySold.route) {
            BuySoldScreen(navController)
        }
        composable(Screens.Recents.route) {
            RecentsScreen(navController)
        }
        composable(Screens.RateExchange.route) {
            RateExchangeScreen(navController)
        }
        composable(Screens.Wallet.route) {
            WalletScreen(navController)
        }
        composable(Screens.Goals.route) {
            GoalsScreen(navController)
        }
        composable(Screens.Settings.route) {
            SettingsScreen(navController)
        }
        composable(Screens.Profile.route) {
            ProfileScreen(navController)
        }
    }
}