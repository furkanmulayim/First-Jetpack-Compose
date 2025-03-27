package com.furkanmulayim.golden.presentation.tab_main.investing_ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.buttons.default_buttons.CustomPrimaryButton
import com.furkanmulayim.golden.core.component.buttons.default_buttons.CustomSecondaryButton
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth

@Composable
fun ButtonSectionWidget(
    navController: NavController
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {


        // BUTTON -> Buy
        CustomSecondaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.do_invest_buy_now),
            iconRes = null,
            onClick = {
            })

        CustomSpacerWidth(10)

        // BUTTON ->Sold
        CustomSecondaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.do_invest_change_now),
            iconRes = null,
            onClick = {
            })

        CustomSpacerWidth(10)

        // BUTTON -> DO INVEST BUTTON
        CustomPrimaryButton(
            modifier = Modifier.weight(1.4f),
            text = stringResource(id = R.string.change_rate),
            iconRes = R.drawable.svg_live_data_square,
            onClick = {
            }

        )
        CustomSpacerWidth(10)
    }
}

