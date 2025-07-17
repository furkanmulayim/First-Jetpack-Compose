package com.furkanmulayim.birikio.ui.screen_exchange_rate.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.component.buttons.icon_button.CustomIconButton
import com.furkanmulayim.birikio.core.component.buttons.icon_button.CustomIconTextButton
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.ui.screen_exchange_rate.viewmodel.ExchangeRateViewModel
import com.furkanmulayim.birikio.ui.theme.AppSize
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonIconsHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.Padding
import com.furkanmulayim.birikio.ui.theme.AppSize.RadiusMedium
import com.furkanmulayim.birikio.ui.theme.AppSize.zero_o_five
import com.furkanmulayim.birikio.ui.theme.twins_75


@Composable
fun ExchangeRateScreen(
    navController: NavHostController, viewModel: ExchangeRateViewModel = viewModel()
) {

    val updateTime by viewModel.updatedAt.collectAsState()
    val curr by viewModel.allMoneys.collectAsState()

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

        Item()
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


@Composable
fun Item() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(RadiusMedium))
            .border(
                width = zero_o_five, color = twins_75, shape = RoundedCornerShape(ButtonIconsHeight)
            )
            .padding(horizontal = Padding, vertical = Padding)
            .fillMaxWidth()
            .height(26.dp)
    ) {

    }
}

