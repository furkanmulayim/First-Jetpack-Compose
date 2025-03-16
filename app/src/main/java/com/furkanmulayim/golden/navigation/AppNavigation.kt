package com.furkanmulayim.golden.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.furkanmulayim.golden.presentation.home.HomeScreen
import com.furkanmulayim.golden.presentation.investing.InvestingScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = AppScreens.HomeScreen.route
    ) {
        composable(
            AppScreens.HomeScreen.route,
            //Home Screen'e dönüşte çalışıyor.
            enterTransition = {
                slideInHorizontally(
                    initialOffsetX = { -1000 }, animationSpec = tween(400)
                )

            },
            /**Home Screen'den giderken çalışıyor. */
            exitTransition = {
                slideOutHorizontally(
                    targetOffsetX = { -1000 }, animationSpec = tween(400)
                )
            },
        ) {
            HomeScreen(navController)
        }
        composable(
            "investing/{beforeScreen}",
        ) { backStackEntry ->
            val invest = backStackEntry.arguments?.getString("beforeScreen") ?: "Geri"
            InvestingScreen(navController, invest)
        }
    }
}