package com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.app_bar.AppBarSection
import com.furkanmulayim.birikio.design.component.card.GeneralCardNoPaddings
import com.furkanmulayim.birikio.design.component.page.CustomScaffold
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.component.ExchangeMoneyVertical
import com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.component.RateCourContent
import com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.component.RateCourHeader
import com.furkanmulayim.birikio.silinecekler.listBeDeletedCurrency

@Composable
fun RateExchangeScreen(
    navController: NavController,
) {
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
            ExchangeSection()
            RateCourSection(onRefreshClick = {}, onItemClick = {})
        }
    }
}

@Composable
private fun ExchangeSection() {
    GeneralCardNoPaddings {
        ExchangeMoneyVertical(listBeDeletedCurrency)
    }
}


@Composable
private fun RateCourSection(onRefreshClick: () -> Unit, onItemClick: () -> Unit) {
    RateCourHeader(date = "12 Haz 23:56", onRefreshClick = onRefreshClick)
    listBeDeletedCurrency.forEach { item ->
        RateCourContent(item, onItemClick)
    }
}
