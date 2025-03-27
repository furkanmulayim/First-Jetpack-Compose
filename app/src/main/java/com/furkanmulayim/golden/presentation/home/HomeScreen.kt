package com.furkanmulayim.golden.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.golden.core.component.InvestmentList
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.presentation.BaseScreen
import com.furkanmulayim.golden.presentation.home.widgets.ButtonSectionWidget
import com.furkanmulayim.golden.presentation.home.widgets.InvestingBalanceSectionWidget
import com.furkanmulayim.golden.presentation.home.widgets.TopBarWidget

@Composable
fun HomeScreen(
    navController: NavController, viewModel: HomeViewModel = viewModel()
) {
    BaseScreen {
        HomeContent(
            navController = navController, viewModel
        )
    }
}

@Composable
private fun HomeContent(
    navController: NavController, viewModel: HomeViewModel
) {
    val investmentList by viewModel.investmentList.collectAsState()
    val investmentBalance by viewModel.investingBalance.collectAsState()
    val today by viewModel.today.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBarWidget(
            today,
            meOnClick = { /** todo Profile sayfasına gidecek */ },
            cardOnClick = { /** todo Credit Card sayfasına gidecek */ },
            walletOnClick = { /** todo Wallet sayfasına gidecek */ },
        )
        InvestingBalanceSectionWidget(totalInvesting = investmentBalance)

        CustomSpacerHeight(32)
        ButtonSectionWidget(navController)
        CustomSpacerHeight(24)
        InvestmentList(investmentList)
    }
}


