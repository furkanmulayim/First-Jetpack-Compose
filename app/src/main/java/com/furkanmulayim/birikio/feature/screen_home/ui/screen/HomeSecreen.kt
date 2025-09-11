package com.furkanmulayim.birikio.feature.screen_home.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomHorizontalDivider
import com.furkanmulayim.birikio.design.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.design.component.page.CustomScaffold
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.selectedBorder
import com.furkanmulayim.birikio.design.theme.unSelectedBorder
import com.furkanmulayim.birikio.feature.screen_home.ui.component.DoubleButtons
import com.furkanmulayim.birikio.feature.screen_home.ui.component.ExchangeMoneyHorizontal
import com.furkanmulayim.birikio.feature.screen_home.ui.component.HomeAppBarSection
import com.furkanmulayim.birikio.feature.screen_home.ui.component.RateList
import com.furkanmulayim.birikio.feature.screen_home.ui.component.RecentActivities
import com.furkanmulayim.birikio.feature.screen_home.ui.component.pagers.BalancePager
import com.furkanmulayim.birikio.feature.screen_home.ui.component.pagers.CardPager
import com.furkanmulayim.birikio.feature.screen_home.ui.viewmodel.HomeViewModel
import com.furkanmulayim.birikio.feature.sheet_buy_sold.ui.screen.BuySoldSheet
import com.furkanmulayim.birikio.navigation.Screens
import com.furkanmulayim.birikio.silinecekler.listBeDeletedCurrency

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController, viewModel: HomeViewModel = viewModel(),
) {
    val textName = stringResource(R.string.hello) + ", Furkan!" // todo name viewModel’den gelecek
    val pagerState = rememberPagerState(pageCount = { 2 })

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var showSheet by remember { mutableStateOf(true) }
    BackHandler(enabled = showSheet) { showSheet = false }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surface)
            .padding(top = Appsize.padding64)
    ) {
        HomeAppBarSection(
            name = textName,
            onProfileClick = { navController.navigate(Screens.Profile.route) },
        )

        CustomScaffold {
            PagerSection(
                pagerState,
                onBalanceClick = { navController.navigate(Screens.Balance.route) },
                onRecentsClick = { navController.navigate(Screens.Recents.route) },
                onBuySoldClick = { showSheet = true },
                onRateExchangeClick = { navController.navigate(Screens.RateExchange.route) })
            DoubleButtonSection(
                leftOnclick = { navController.navigate(Screens.Goals.route) },
                rightOnClick = { navController.navigate(Screens.Wallet.route) })
            RateSection(
                rateClick = { navController.navigate(Screens.RateExchange.route) })
            RecentList(
                allViewOnClick = { navController.navigate(Screens.Recents.route) })
        }

        if (showSheet) {
            ModalBottomSheet(
                sheetState = sheetState, onDismissRequest = { showSheet = false }) {
                BuySoldSheet(isBuySelected = true)
            }
        }
    }
}


@Composable
private fun PagerSection(
    pagerState: PagerState,
    onBalanceClick: () -> Unit,
    onRecentsClick: () -> Unit,
    onBuySoldClick: () -> Unit,
    onRateExchangeClick: () -> Unit,
) {

    HorizontalPager(
        state = pagerState, modifier = Modifier.fillMaxWidth()
    ) { page ->
        when (page) {
            0 -> BalancePager(onBalanceClick, onRecentsClick, onBuySoldClick, onRateExchangeClick)
            1 -> CardPager()
        }
    }
    CustomSpacerHeight(Appsize.padding6)

    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color =
                if (pagerState.currentPage == iteration) selectedBorder else unSelectedBorder
            Box(
                modifier = Modifier
                    .padding(Appsize.padding4)
                    .height(Appsize.size3)
                    .width(Appsize.size24)
                    .clip(CircleShape)
                    .background(color)
            )
        }
    }
}

@Composable
private fun DoubleButtonSection(leftOnclick: () -> Unit, rightOnClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DoubleButtons(
            leftOnClick = leftOnclick, rightOnClick = rightOnClick
        )
    }
}


@Composable
private fun RateSection(rateClick: () -> Unit) {
    val list = listBeDeletedCurrency

    Column(
        modifier = Modifier.border(
            width = 0.5.dp,
            color = colorScheme.outline,
            shape = RoundedCornerShape(Appsize.radius16)
        ),
    ) {
        RateList(list.dropLast(1), rateClick)
        CustomHorizontalDivider()
        ExchangeMoneyHorizontal(list)
    }
}

@Composable
private fun RecentList(allViewOnClick: () -> Unit) {
    RecentActivities(isShowButtonVisible = true, allViewOnClick)
}