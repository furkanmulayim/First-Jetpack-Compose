package com.furkanmulayim.birikio.ui.screen_investing.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.component.buttons.icon_button.CustomIconButton
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.nav.AppScreens
import com.furkanmulayim.birikio.ui.bottom_sheet_buy_sold_invest.view.InvestBuySoldBottomSheet
import com.furkanmulayim.birikio.ui.bottom_sheet_swap.view.SwapBottomSheet
import com.furkanmulayim.birikio.ui.screen_investing.compose.ButtonSectionWidget
import com.furkanmulayim.birikio.ui.screen_investing.compose.InvestingBalanceSectionWidget
import com.furkanmulayim.birikio.ui.screen_investing.compose.InvestmentList
import com.furkanmulayim.birikio.ui.screen_investing.compose.TickerBasicMarquee
import com.furkanmulayim.birikio.ui.screen_investing.viewmodel.HomeViewModel
import com.furkanmulayim.birikio.ui.theme.AppSize
import kotlinx.coroutines.launch

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
    val goldState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {


        var showCurrencySwapBottomSheet by remember { mutableStateOf(false) }
        val coroutineScope = rememberCoroutineScope()

        SwapBottomSheet(
            showBottomSheet = showCurrencySwapBottomSheet,
            onDismiss = { showCurrencySwapBottomSheet = false })

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    top = AppSize.PaddingXLarge,
                    start = AppSize.PaddingLarge,
                    end = AppSize.PaddingLarge
                )
                .height(AppSize.ButtonHeight), verticalAlignment = Alignment.CenterVertically
        ) {
            // SOLDAKİ MENÜ ICON
            CustomIconButton(
                icon = R.drawable.svg_icon_burger_menu, onClick = {})

            // ORTADAKİ TEXT + INDICATOR
            Box(
                modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
            ) {

            }

            // SAĞDAKİ SETTINGS ICON
            CustomIconButton(
                icon = R.drawable.svg_icon_swap, onClick = {
                    coroutineScope.launch {
                        showCurrencySwapBottomSheet = true
                    }
                })
        }

        InvestingBalanceSectionWidget(
            totalInvesting = investmentBalance, isInvesting = true
        ) // Balance Money
        CustomSpacerHeight(16)
        TickerBasicMarquee(goldState)
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
