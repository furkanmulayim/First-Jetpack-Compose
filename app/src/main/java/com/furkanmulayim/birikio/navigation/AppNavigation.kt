package com.furkanmulayim.birikio.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.furkanmulayim.birikio.feature.screen_balance.ui.screen.BalanceScreen
import com.furkanmulayim.birikio.feature.screen_buy_sold.ui.screen.BuySoldScreen
import com.furkanmulayim.birikio.feature.screen_goals.ui.screen.GoalsScreen
import com.furkanmulayim.birikio.feature.screen_home.ui.screen.HomeScreen
import com.furkanmulayim.birikio.feature.screen_onboarding.ui.screen.OnboardingScreen
import com.furkanmulayim.birikio.feature.screen_profile.ui.screen.ProfileScreen
import com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.screen.RateExchangeScreen
import com.furkanmulayim.birikio.feature.screen_recents.ui.screen.RecentsScreen
import com.furkanmulayim.birikio.feature.screen_wallet.ui.screen.WalletScreen

// Animation constants
private const val ANIMATION_DURATION = 300

// Enter animations (sağdan sola giriş)
private val slideInFromRight = slideInHorizontally(
    initialOffsetX = { fullWidth -> fullWidth },
    animationSpec = tween(ANIMATION_DURATION)
)

// Exit animations (soldan sağa çıkış)
private val slideOutToLeft = slideOutHorizontally(
    targetOffsetX = { fullWidth -> -fullWidth },
    animationSpec = tween(ANIMATION_DURATION)
)

// Pop enter animations (soldan sağa giriş - geri gelirken)
private val slideInFromLeft = slideInHorizontally(
    initialOffsetX = { fullWidth -> -fullWidth },
    animationSpec = tween(ANIMATION_DURATION)
)

// Pop exit animations (sağdan sola çıkış - geri giderken)
private val slideOutToRight = slideOutHorizontally(
    targetOffsetX = { fullWidth -> fullWidth },
    animationSpec = tween(ANIMATION_DURATION)
)

@Composable
fun AppNavigation(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        enterTransition = { slideInFromRight },
        exitTransition = { slideOutToLeft },
        popEnterTransition = { slideInFromLeft },
        popExitTransition = { slideOutToRight }
    ) {

        composable(route = Screens.Onboarding.route) {
            OnboardingScreen(
                onStartClicked = {
                    navController.navigate(Screens.Home.route) {
                        popUpTo(Screens.Onboarding.route) { inclusive = true }
                    }
                })
        }

        composable(route = Screens.Home.route) {
            HomeScreen(navController)
        }

        composable(route = Screens.Balance.route) {
            BalanceScreen(navController)
        }

        composable(route = Screens.BuySold.route) {
            BuySoldScreen(navController)
        }

        composable(route = Screens.Recents.route) {
            RecentsScreen(navController)
        }

        composable(route = Screens.RateExchange.route) {
            RateExchangeScreen(navController)
        }

        composable(route = Screens.Wallet.route) {
            WalletScreen(navController)
        }

        composable(route = Screens.Goals.route) {
            GoalsScreen(navController)
        }


        composable(route = Screens.Profile.route) {
            ProfileScreen(navController)
        }
    }
}
