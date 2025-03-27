package com.furkanmulayim.golden.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.furkanmulayim.golden.presentation.tab_main.home_tab_ui.HomeScreen
import com.furkanmulayim.golden.presentation.tab_main.investing_ui.InvestingScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController, startDestination = AppScreens.HomeScreen.route
    ) {
        composable(
            AppScreens.HomeScreen.route,
            //Home Screen'e dönüşte çalışıyor.
//            enterTransition = {
//                slideInHorizontally(
//                    initialOffsetX = { -1000 }, animationSpec = tween(400)
//                )
//
//            },
            /**Home Screen'den giderken çalışıyor. */
//            exitTransition = {
//                slideOutHorizontally(
//                    targetOffsetX = { -1000 }, animationSpec = tween(400)
//                )
//            },
        ) {
            HomeScreen(navController)
        }
        composable(
            "investing/{beforeScreen}",
        ) { backStackEntry ->
            InvestingScreen(navController)
        }
    }
}