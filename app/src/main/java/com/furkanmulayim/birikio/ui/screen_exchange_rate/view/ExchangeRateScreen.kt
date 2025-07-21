package com.furkanmulayim.birikio.ui.screen_exchange_rate.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.component.buttons.icon_button.CustomIconButton
import com.furkanmulayim.birikio.core.component.buttons.icon_button.CustomIconTextButton
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.core.enums.InvestE
import com.furkanmulayim.birikio.core.state.UiState
import com.furkanmulayim.birikio.ui.screen_exchange_rate.viewmodel.ExchangeRateViewModel
import com.furkanmulayim.birikio.ui.theme.AppSize


@Composable
fun ExchangeRateScreen(
    navController: NavHostController, viewModel: ExchangeRateViewModel = viewModel()
) {

    val uiState by viewModel.uiState.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppSize.PaddingLarge)
    ) {

        // Üstteki geri butonu
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppSize.PaddingXLarge)
                .height(AppSize.ButtonHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomIconTextButton(
                icon = R.drawable.svg_icon_arrow_left, onClick = {
                    navController.popBackStack()
                }, text = "Geri"
            )

            // SOLDAKİ MENÜ ICON
            CustomIconButton(
                icon = R.drawable.svg_icon_rate_currency, onClick = {})

        }
        CustomSpacerHeight(20)

        when (uiState) {
            is UiState.Loading -> {
                CircularProgressIndicator()
            }

            is UiState.Success -> {
                val data = (uiState as UiState.Success).data
                val moneyItems = listOf(
                    InvestE.DOLLAR.value to data.usd,
                    InvestE.EURO.value to data.eur,
                    InvestE.GRAM24.value to data.gram24,
                    InvestE.GRAM22.value to data.gram22,
                    InvestE.CEYREK.value to data.ceyrek,
                    InvestE.YARIM.value to data.yarim,
                    InvestE.TAM.value to data.tam,
                    InvestE.RESAT.value to data.resat
                )

                moneyItems.forEach { (name, value) ->
                    CustomSpacerHeight(10)
                    Text(text = "$name: $value")
                }
            }

            is UiState.Error -> {
                val message = (uiState as UiState.Error).message
                Text("Hata: $message")
            }
        }


    }
}