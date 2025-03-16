package com.furkanmulayim.golden.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.models.InvestModel
import com.furkanmulayim.golden.navigation.AppScreens
import com.furkanmulayim.golden.presentation.BaseScreen
import com.furkanmulayim.golden.presentation.home.widgets.ButtonSectionWidget
import com.furkanmulayim.golden.presentation.home.widgets.InvestListItem
import com.furkanmulayim.golden.presentation.home.widgets.InvestingBalanceSectionWidget
import com.furkanmulayim.golden.presentation.home.widgets.TopBarWidget
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.CustomTypo

@Composable
fun HomeScreen(
    navController: NavController, viewModel: HomeViewModel = viewModel()
) {
    BaseScreen {
        HomeContent(
            navController = navController, viewModel
        )
    }
}

@Composable
private fun HomeContent(
    navController: NavController, viewModel: HomeViewModel
) {
    val investmentList by viewModel.investmentList.collectAsState()
    val investmentBalance by viewModel.investingBalance.collectAsState()
    val today by viewModel.today.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HomeTopBar(today)
        InvestingBalanceSection(investmentBalance)
        HomeButtons(navController)
        InvestmentList(investmentList)
    }
}

@Composable
private fun HomeTopBar(today: String) {
    TopBarWidget(
        today,
        meOnClick = { /** todo Profile sayfasına gidecek */ },
        cardOnClick = { /** todo Credit Card sayfasına gidecek */ },
        walletOnClick = { /** todo Wallet sayfasına gidecek */ },
    )
}

@Composable
private fun InvestingBalanceSection(totalInvesting: String) {
    InvestingBalanceSectionWidget(totalInvesting = totalInvesting)
}

@Composable
private fun HomeButtons(navController: NavController) {
    val goingToInvestingArgument = stringResource(id = R.string.backHome)
    ButtonSectionWidget(
        doIncestingOnClick = {
            navController.navigate(AppScreens.InvestingScreen.go(goingToInvestingArgument))
        },
        exchangeRateOnClick = { /** todo Exchange Rate sayfasına gidecek */ },
    )
}

@Composable
private fun InvestmentList(list: List<InvestModel>?) {
    val historyListText = stringResource(id = R.string.history_list)
    Text(
        text = historyListText,
        style = CustomTypo.text.labelLarge.copy(color = MaterialTheme.colorScheme.tertiary),
    )
    CustomSpacerHeight(12)
    when {
        list == null -> StateIsLoading()
        list.isEmpty() -> StateIsEmpty()
        else -> StateIsSuccess(list)
    }
}

@Composable
private fun StateIsEmpty() {
    /** todo Eğer liste boş ise buraya yazılacak. */
}

@Composable
private fun StateIsLoading() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.size(AppSize.ButtonHeight))
    }
}

@Composable
private fun StateIsSuccess(list: List<InvestModel>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list) { investment ->
            InvestListItem(investment)
            CustomSpacerHeight(6)
        }
    }
}