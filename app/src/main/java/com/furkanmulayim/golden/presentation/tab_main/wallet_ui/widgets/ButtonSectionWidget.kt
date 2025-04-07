package com.furkanmulayim.golden.presentation.tab_main.wallet_ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.buttons.default_buttons.CustomPrimaryButton
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.presentation.theme.AppSize

@Composable
fun ButtonSectionWidget(
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AppSize.PaddingLarge),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {


        // BUTTON -> Buy
        CustomPrimaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.wallet_total_invest),
            iconRes = R.drawable.svg_invest_buy,
            onClick = {})

        CustomSpacerWidth(4)

        // BUTTON ->Sold
        CustomPrimaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.wallet_total_outvest),
            iconRes = R.drawable.svg_invest_sold,
            onClick = {})

        CustomSpacerWidth(4)

        // BUTTON -> GRAPHİC
        CustomPrimaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.wallet_total_detail),
            iconRes = R.drawable.svg_graphic,
            onClick = {})

        CustomSpacerWidth(4)

        // BUTTON -> LIVE
        CustomPrimaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.wallet_cards),
            iconRes = R.drawable.svg_card,
            onClick = {})
    }
}