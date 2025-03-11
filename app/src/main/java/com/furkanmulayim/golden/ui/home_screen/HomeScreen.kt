package com.furkanmulayim.golden.ui.home_screen

import ButtonSection
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.navigation.AppScreens
import com.furkanmulayim.golden.ui.BaseScreen
import com.furkanmulayim.golden.ui.home_screen.widgets.InvestingBalanceSection
import com.furkanmulayim.golden.ui.home_screen.widgets.TopBar
import com.furkanmulayim.golden.ui.theme.CustomTypo

@Composable
fun HomeScreen(navController: NavController) {
    BaseScreen {
        val goingToInvestingArgument = stringResource(id = R.string.backHome)
        val historyListText = stringResource(id = R.string.history_list)
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
        Text(
            text = historyListText,
            style = CustomTypo.text.headlineLarge.copy(color = MaterialTheme.colorScheme.tertiaryContainer)
        )
        // ChartsSection
        // LastInvestingSection
    }
}