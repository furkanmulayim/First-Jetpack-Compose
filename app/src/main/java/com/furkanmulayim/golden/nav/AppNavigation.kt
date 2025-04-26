package com.furkanmulayim.golden.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.furkanmulayim.golden.ui.iban_page.view.IbanScreen
import com.furkanmulayim.golden.ui.tab_pages.tab_home_ui.view.HomeScreen
import com.furkanmulayim.golden.ui.tab_pages.tab_investing_ui.view.InvestingScreen

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
    }
}