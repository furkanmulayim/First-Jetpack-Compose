package com.furkanmulayim.golden.presentation.tab_main.investing_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.golden.core.component.InvestmentList
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.others.InvestingBalanceSectionWidget
import com.furkanmulayim.golden.presentation.tab_main.home_tab_ui.HomeViewModel
import com.furkanmulayim.golden.presentation.tab_main.investing_ui.widget.ButtonSectionWidget
import com.furkanmulayim.golden.presentation.theme.AppSize

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
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppSize.PaddingLarge)
    ) {

        InvestingBalanceSectionWidget(totalInvesting = investmentBalance, isInvesting = true)
        CustomSpacerHeight(32)
        ButtonSectionWidget(navController)
        CustomSpacerHeight(24)
        InvestmentList(investmentList)
    }
}


