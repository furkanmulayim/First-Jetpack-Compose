package com.furkanmulayim.golden.presentation.tab_main.wallet_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.golden.core.component.InvestmentList
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.others.InvestingBalanceSectionWidget
import com.furkanmulayim.golden.core.component.others.LocalAppNavController
import com.furkanmulayim.golden.presentation.tab_main.wallet_ui.widgets.ButtonSectionWidget
import com.furkanmulayim.golden.presentation.theme.AppSize

@Composable
fun WalletScreen(
    navController: NavController, viewModel: InvestingViewModel = viewModel()
) {
    CompositionLocalProvider(LocalAppNavController provides navController) {
        WalletContent(
            viewModel = viewModel, navController = navController
        )

    }
}

@Composable
private fun WalletContent(
    navController: NavController, viewModel: InvestingViewModel
) {
    val investmentList by viewModel.investmentList.collectAsState()
    val investmentBalance by viewModel.investingBalance.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppSize.PaddingLarge)
    ) {
        InvestingBalanceSectionWidget(totalInvesting = investmentBalance, isInvesting = false)
        CustomSpacerHeight(32)
        ButtonSectionWidget(navController = navController)
        // todo BURAYA ARAMA CUBUĞU KOYULACAK
        InvestmentList(investmentList)

    }

}
