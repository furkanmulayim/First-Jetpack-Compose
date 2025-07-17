package com.furkanmulayim.birikio.ui.screens_tab.screen_wallet.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
import com.furkanmulayim.birikio.core.component.others.LocalAppNavController
import com.furkanmulayim.birikio.ui.bottom_sheet_income_expense_wallet.view.WalletIncomeExpenseBottomSheet
import com.furkanmulayim.birikio.ui.screens_tab.screen_wallet.compose.ButtonSectionWidget
import com.furkanmulayim.birikio.ui.screens_tab.screen_wallet.compose.TripleCards
import com.furkanmulayim.birikio.ui.screens_tab.screen_wallet.compose.WalletBalanceSectionWidget
import com.furkanmulayim.birikio.ui.screens_tab.screen_wallet.compose.WalletList
import com.furkanmulayim.birikio.ui.screens_tab.screen_wallet.viewmodel.WalletViewModel

@Composable
fun WalletScreen(
    navController: NavController, viewModel: WalletViewModel = viewModel()
) {
    CompositionLocalProvider(LocalAppNavController provides navController) {
        WalletContent(
            viewModel = viewModel, navController = navController
        )

    }
}

@Composable
private fun WalletContent(
    navController: NavController, viewModel: WalletViewModel
) {

    var showIncomeExpenseBottomSheet by remember { mutableStateOf(false) }
    var walletType by remember { mutableStateOf("") }
    var isBuyColor: Boolean by remember { mutableStateOf(true) }

    val buyString = stringResource(id = R.string.do_wallet_buy)
    val soldString = stringResource(id = R.string.do_wallet_change)

    WalletIncomeExpenseBottomSheet(
        showBottomSheet = showIncomeExpenseBottomSheet,
        onDismiss = { showIncomeExpenseBottomSheet = false },
        walletType = walletType,
        isBuyColor = isBuyColor
    )

    val investmentList by viewModel.investmentList.collectAsState()
    val investmentBalance by viewModel.investingBalance.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        WalletBalanceSectionWidget(totalInvesting = investmentBalance, isInvesting = false)
        CustomSpacerHeight(12)
        TripleCards(invest = "212.175", outvest = "97.698")
        CustomSpacerHeight(12)
        ButtonSectionWidget(navController = navController, buyOnClick = {
            walletType = buyString
            isBuyColor = true
            showIncomeExpenseBottomSheet = true
        }, soldOnClick = {
            walletType = soldString
            isBuyColor = false
            showIncomeExpenseBottomSheet = true
        })
        // todo BURAYA ARAMA CUBUĞU KOYULACAK
        WalletList(investmentList)
    }

}
