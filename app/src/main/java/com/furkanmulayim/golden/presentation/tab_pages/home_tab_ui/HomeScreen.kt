package com.furkanmulayim.golden.presentation.tab_pages.home_tab_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.golden.presentation.tab_pages.investing_ui.InvestingScreen
import com.furkanmulayim.golden.presentation.tab_pages.wallet_ui.WalletScreen
import com.furkanmulayim.golden.presentation.tab_pages.widgets.GenderSelector
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = viewModel()) {
    val pagerState = rememberPagerState(
        initialPage = 0, initialPageOffsetFraction = 0.0f, pageCount = { 2 })
    val scope = rememberCoroutineScope()

    Column {

        GenderSelector(
            selectedIndex = pagerState.currentPage, onSelectionChanged = { index ->
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
            })

        HorizontalPager(
            state = pagerState
        ) { page ->
            when (page) {
                0 -> InvestingScreen(navController = navController)
                1 -> WalletScreen(navController = navController)
            }
        }
    }
}
