package com.furkanmulayim.golden.presentation.investing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.golden.core.component.InvestmentList
import com.furkanmulayim.golden.core.component.others.CustomTopBarWidget
import com.furkanmulayim.golden.core.component.others.LocalAppNavController
import com.furkanmulayim.golden.presentation.BaseScreen
import com.furkanmulayim.golden.presentation.investing.widgets.ButtonSectionWidget
import com.furkanmulayim.golden.presentation.investing.widgets.InvestingBalanceSectionWidget

@Composable
fun InvestingScreen(
    navController: NavController, bundle: String, viewModel: InvestingViewModel = viewModel()
) {
    CompositionLocalProvider(LocalAppNavController provides navController) {
        BaseScreen {
            InvestingContent(
                backName = bundle, viewModel = viewModel, navController = navController
            )
        }
    }
}

@Composable
private fun InvestingContent(
    navController: NavController, backName: String, viewModel: InvestingViewModel
) {
    val investmentList by viewModel.investmentList.collectAsState()
    val investmentBalance by viewModel.investingBalance.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopBarWidget(
            backName = backName,
            leadingClick = {},
        )
        InvestingBalanceSectionWidget(totalInvesting = investmentBalance)
        ButtonSectionWidget(navController = navController)
        // todo BURAYA ARAMA CUBUĞU KOYULACAK
        InvestmentList(investmentList)

    }

}
