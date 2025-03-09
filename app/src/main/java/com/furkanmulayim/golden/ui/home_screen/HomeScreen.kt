package com.furkanmulayim.golden.ui.home_screen

import ButtonSection
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.navigation.AppScreens
import com.furkanmulayim.golden.ui.BaseScreen
import com.furkanmulayim.golden.ui.home_screen.widgets.InvestingBalanceSection
import com.furkanmulayim.golden.ui.home_screen.widgets.TopBar

@Composable
fun HomeScreen(navController: NavController) {
    BaseScreen {

        val goingToInvestingArgument = stringResource(id = R.string.backHome)
        TopBar(
            meOnClick = { /** toDo Profile sayfasına gidecek */ },
            cardOnClick = { /** toDo Credit_Card  sayfasına gidecek */ },
            walletOnClick = { /** toDo Wallet sayfasına gidecek */ },
        )
        InvestingBalanceSection(
            totalInvesting = "3.412,50"
        )
        ButtonSection(
            doIncestingOnClick = {
                navController.navigate(AppScreens.InvestingScreen.go(goingToInvestingArgument))
            },
            exchangeRateOnClick = { /** toDo Exchange_Rate sayfasına gidecek */ },
        )
        // ChartsSection
        // LastInvestingSection
    }
}