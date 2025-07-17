package com.furkanmulayim.birikio.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.furkanmulayim.birikio.ui.screen_exchange_rate.view.ExchangeRateScreen
import com.furkanmulayim.birikio.ui.screen_save_iban.view.IbanScreen
import com.furkanmulayim.birikio.ui.screens_tab.screen_home.view.HomeScreen
import com.furkanmulayim.birikio.ui.screens_tab.screen_investing.view.InvestingScreen

// AppNavigation.kt
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = AppScreens.HomeScreen.route
    ) {
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(AppScreens.InvestingScreen.route) {
            InvestingScreen(navController)
        }

        composable(AppScreens.IbanScreen.route) {
            IbanScreen(navController)
        }

        composable(AppScreens.ExchangeRateScreen.route) {
            ExchangeRateScreen(navController)
        }
    }
}