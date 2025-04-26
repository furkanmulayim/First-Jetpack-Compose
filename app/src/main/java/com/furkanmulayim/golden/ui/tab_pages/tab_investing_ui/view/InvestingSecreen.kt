package com.furkanmulayim.golden.ui.tab_pages.tab_investing_ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.ui.tab_pages.tab_home_ui.viewmodel.HomeViewModel
import com.furkanmulayim.golden.ui.tab_pages.tab_investing_ui.compose.ButtonSectionWidget
import com.furkanmulayim.golden.ui.tab_pages.tab_investing_ui.compose.InvestingBalanceSectionWidget
import com.furkanmulayim.golden.ui.tab_pages.tab_investing_ui.compose.InvestmentList
import com.furkanmulayim.golden.ui.tab_pages.tab_investing_ui.compose.TickerBasicMarquee

@Composable
fun InvestingScreen(
    navController: NavController, viewModel: HomeViewModel = viewModel()
) {
    InvestingContent(
        navController = navController, viewModel
    )
}

@Composable
private fun InvestingContent(
    navController: NavController, viewModel: HomeViewModel
) {
    val investmentList by viewModel.investmentList.collectAsState()
    val investmentBalance by viewModel.investingBalance.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        InvestingBalanceSectionWidget(
            totalInvesting = investmentBalance, isInvesting = true
        ) // Balance Money
        CustomSpacerHeight(16)
        TickerBasicMarquee() // Slide Text
        CustomSpacerHeight(16)
        ButtonSectionWidget(navController) // Buttons
        CustomSpacerHeight(24)
        InvestmentList(investmentList) // List
    }
}
