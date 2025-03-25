package com.furkanmulayim.golden.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.models.InvestModel
import com.furkanmulayim.golden.navigation.AppScreens
import com.furkanmulayim.golden.presentation.BaseScreen
import com.furkanmulayim.golden.presentation.home.widgets.ButtonSectionWidget
import com.furkanmulayim.golden.presentation.home.widgets.InvestListItemWidget
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
            navController = navController, viewModel = viewModel
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

// TOP BAR
@Composable
private fun HomeTopBar(today: String) {
    TopBarWidget(
        today,
        meOnClick = { /** todo Profile sayfasına gidecek */ },
        cardOnClick = { /** todo Credit Card sayfasına gidecek */ },
        walletOnClick = { /** todo Wallet sayfasına gidecek */ },
    )
}

//TOTAL INVEST MONEY SECTİON
@Composable
private fun InvestingBalanceSection(totalInvesting: String) {
    InvestingBalanceSectionWidget(totalInvesting = totalInvesting)
}

// TWO BUTTONS SECTION
@Composable
private fun HomeButtons(navController: NavController) {
    val firstStr = stringResource(id = R.string.my_investing)
    val secondStr = stringResource(id = R.string.my_investing)
    val goingToInvestingArgument = stringResource(id = R.string.backHome)
    CustomSpacerHeight(32)
    ButtonSectionWidget(
        firstText = firstStr,
        firstClick = {
            navController.navigate(AppScreens.InvestingScreen.go(goingToInvestingArgument))
        },
        firstIcon = R.drawable.svg_investings,

        secondText = secondStr,
        secondIcon = R.drawable.svg_live_data,
        secondClick = {
            navController.navigate(AppScreens.InvestingScreen.go(goingToInvestingArgument))
        },
    )
    CustomSpacerHeight(24)
}

//LİST SECTION
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

// IF EMPTY LIST
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

// IF SUCCES STATE
@Composable
private fun StateIsSuccess(list: List<InvestModel>) {

    LazyColumn(
        modifier = Modifier
            .padding(bottom = 48.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(AppSize.RadiusButtons))
            .background(MaterialTheme.colorScheme.surface)
    ) {
        items(list) { investment ->
            InvestListItemWidget(investment, onClick = {})
        }
    }
}
