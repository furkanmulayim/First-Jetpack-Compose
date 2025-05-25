package com.furkanmulayim.birikio.ui.tab_pages.tab_home_ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.birikio.ui.tab_pages.compose.GenderSelector
import com.furkanmulayim.birikio.ui.tab_pages.tab_home_ui.viewmodel.HomeViewModel
import com.furkanmulayim.birikio.ui.tab_pages.tab_investing_ui.view.InvestingScreen
import com.furkanmulayim.birikio.ui.tab_pages.tab_wallet_ui.view.WalletScreen
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
