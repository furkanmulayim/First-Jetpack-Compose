package com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.app_bar.AppBarSection
import com.furkanmulayim.birikio.design.component.card.GeneralCardNoPaddings
import com.furkanmulayim.birikio.design.component.page.CustomScaffold
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.feature.screen_home.data.model.TickerItem
import com.furkanmulayim.birikio.feature.screen_home.ui.viewmodel.HomeViewModel
import com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.component.ExchangeMoneyVertical
import com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.component.RateCourContent
import com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.component.RateCourHeader
import kotlinx.coroutines.flow.StateFlow

@Composable
fun RateExchangeScreen(
    navController: NavController, homeViewModel: HomeViewModel,
) {
    homeViewModel.retryFetchData()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surfaceVariant)
            .padding(top = Appsize.padding64)
    ) {
        AppBarSection(
            name = stringResource(R.string.nameExchange),
            onBackClick = { navController.popBackStack() })

        CustomScaffold {
            ExchangeSection(homeViewModel.tickers)
            RateCourSection(
                onRefreshClick = {
                    homeViewModel.retryFetchData()
                },
                onItemClick = {},
                listi = homeViewModel.tickers,
                lastUpdate = homeViewModel.lastUpdate
            )
        }
    }
}

@Composable
private fun ExchangeSection(tickers: StateFlow<List<TickerItem>>) {
    GeneralCardNoPaddings {
        ExchangeMoneyVertical(tickers)
    }
}


@Composable
private fun RateCourSection(
    listi: StateFlow<List<TickerItem>>,
    onRefreshClick: () -> Unit,
    onItemClick: () -> Unit,
    lastUpdate: StateFlow<String>,
) {
    RateCourHeader(date = lastUpdate, onRefreshClick = onRefreshClick)
    val filteredList = listi.collectAsState().value.filterNot { it.code == "TL" }

    filteredList.forEach { item ->
        RateCourContent(item, onItemClick)
    }
}
