package com.furkanmulayim.golden.presentation.tab_main.wallet_ui.widgets

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
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth

@Composable
fun ButtonSectionWidget(
    navController: NavController
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        val goingToInvestingArgument = stringResource(id = R.string.backInvesting)

        // BUTTON -> DO INVEST BUTTON
        CustomPrimaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.invest_buy),
            iconRes = R.drawable.svg_invest_buy,
            onClick = {

            }

        )
        CustomSpacerWidth(10)

        // BUTTON -> LIVE DATA
        CustomSecondaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.invest_sold),
            iconRes = R.drawable.svg_invest_sold,
            onClick = {

            })
    }
    CustomSpacerHeight(24)
}

