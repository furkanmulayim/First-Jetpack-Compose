package com.furkanmulayim.golden.navigation


import HomeScreen
import InvestingScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AppScreens.HomeScreen.route
    ) {
        composable(AppScreens.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable("investing/{beforeScreen}") { backStackEntry ->
            val invest = backStackEntry.arguments?.getString("beforeScreen") ?: "Bilinmiyor"
            InvestingScreen(navController, invest)
        }
    }
}
