package com.furkanmulayim.birikio.ui.tab_pages.tab_investing_ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.ui.invest_buy_sold_bottom_sheet.view.InvestBuySoldBottomSheet
import com.furkanmulayim.birikio.ui.tab_pages.tab_home_ui.viewmodel.HomeViewModel
import com.furkanmulayim.birikio.ui.tab_pages.tab_investing_ui.compose.ButtonSectionWidget
import com.furkanmulayim.birikio.ui.tab_pages.tab_investing_ui.compose.InvestingBalanceSectionWidget
import com.furkanmulayim.birikio.ui.tab_pages.tab_investing_ui.compose.InvestmentList
import com.furkanmulayim.birikio.ui.tab_pages.tab_investing_ui.compose.TickerBasicMarquee

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

    var showBuySoldBottomSheet by remember { mutableStateOf(false) }

    InvestBuySoldBottomSheet(
        showBottomSheet = showBuySoldBottomSheet, onDismiss = { showBuySoldBottomSheet = false })

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
        ButtonSectionWidget(navController, buyOnClick = {
            showBuySoldBottomSheet = true
        }, soldOnClick = {}, graphicOnClick = {}, liveOnClick = {}) // Buttons
        CustomSpacerHeight(24)
        InvestmentList(investmentList) // List
    }
}
