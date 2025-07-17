package com.furkanmulayim.birikio.ui.screens_tab.screen_investing.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.nav.AppScreens
import com.furkanmulayim.birikio.ui.bottom_sheet_buy_sold_invest.view.InvestBuySoldBottomSheet
import com.furkanmulayim.birikio.ui.screens_tab.screen_home.viewmodel.HomeViewModel
import com.furkanmulayim.birikio.ui.screens_tab.screen_investing.compose.ButtonSectionWidget
import com.furkanmulayim.birikio.ui.screens_tab.screen_investing.compose.InvestingBalanceSectionWidget
import com.furkanmulayim.birikio.ui.screens_tab.screen_investing.compose.InvestmentList
import com.furkanmulayim.birikio.ui.screens_tab.screen_investing.compose.TickerBasicMarquee

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
    var investType by remember { mutableStateOf("") }
    var isBuyColor: Boolean by remember { mutableStateOf(true) }

    val buyString = stringResource(id = R.string.do_invest_buy)
    val soldString = stringResource(id = R.string.do_invest_change)

    InvestBuySoldBottomSheet(
        showBottomSheet = showBuySoldBottomSheet,
        onDismiss = { showBuySoldBottomSheet = false },
        investType = investType,
        isBuyColor = isBuyColor
    )

    val investmentList by viewModel.investmentList.collectAsState()
    val investmentBalance by viewModel.investingBalance.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        InvestingBalanceSectionWidget(
            totalInvesting = investmentBalance, isInvesting = true
        ) // Balance Money
        CustomSpacerHeight(16)
        TickerBasicMarquee()
        CustomSpacerHeight(16)
        ButtonSectionWidget(navController, buyOnClick = {
            investType = buyString
            isBuyColor = true
            showBuySoldBottomSheet = true
        }, soldOnClick = {
            investType = soldString
            isBuyColor = false
            showBuySoldBottomSheet = true
        }, graphicOnClick = {}, liveOnClick = {
            navController.navigate(AppScreens.ExchangeRateScreen.route)
        })
        CustomSpacerHeight(24)
        InvestmentList(investmentList)
    }
}
