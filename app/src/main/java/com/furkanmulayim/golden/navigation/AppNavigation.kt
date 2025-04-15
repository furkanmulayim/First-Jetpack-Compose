package com.furkanmulayim.golden.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.furkanmulayim.golden.presentation.iban_page.IbanScreen
import com.furkanmulayim.golden.presentation.tab_pages.home_tab_ui.HomeScreen
import com.furkanmulayim.golden.presentation.tab_pages.investing_ui.InvestingScreen

// AppNavigation.kt
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = AppScreens.IbanScreen.route
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
    }
}