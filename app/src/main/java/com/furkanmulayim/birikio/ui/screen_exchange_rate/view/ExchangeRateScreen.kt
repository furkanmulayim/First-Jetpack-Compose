package com.furkanmulayim.birikio.ui.screen_exchange_rate.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.ui.screen_exchange_rate.viewmodel.ExchangeRateViewModel


@Composable
fun ExchangeRateScreen(
    navController: NavHostController, viewModel: ExchangeRateViewModel = viewModel()
) {

    val updateTime by viewModel.updatedAt.collectAsState()
    val curr by viewModel.allMoneys.collectAsState()

    Column {
        CustomSpacerHeight(60)
        Text("Güncelleme Zamanı: $updateTime")
        CustomSpacerHeight(10)
        Text("USD: ${curr?.usd}")
        CustomSpacerHeight(10)
        Text("eur: ${curr?.eur}")
        CustomSpacerHeight(10)
        Text("gram24: ${curr?.gram24}")
        CustomSpacerHeight(10)
        Text("gram22: ${curr?.gram22}")
        CustomSpacerHeight(10)
        Text("ceyrek: ${curr?.ceyrek}")
        CustomSpacerHeight(10)
        Text("yarim: ${curr?.yarim}")
        CustomSpacerHeight(10)
        Text("tam: ${curr?.tam}")
        CustomSpacerHeight(10)
        Text("resat: ${curr?.resat}")
    }
}


