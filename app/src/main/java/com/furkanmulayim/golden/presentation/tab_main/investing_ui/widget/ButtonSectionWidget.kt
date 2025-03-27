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
import com.furkanmulayim.golden.navigation.AppScreens

@Composable
fun ButtonSectionWidget(
    navController: NavController
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        val goingToInvestingArgument = stringResource(id = R.string.backHome)

        // BUTTON -> DO INVEST BUTTON
        CustomPrimaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.my_investing),
            iconRes = R.drawable.svg_investings,
            onClick = {
                navController.navigate(AppScreens.InvestingScreen.go(goingToInvestingArgument))
            }

        )
        CustomSpacerWidth(10)

        // BUTTON -> LIVE DATA
        CustomSecondaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.exchange_rate),
            iconRes = R.drawable.svg_live_data,
            onClick = {
                navController.navigate(AppScreens.InvestingScreen.go(goingToInvestingArgument))
            })
    }
}

