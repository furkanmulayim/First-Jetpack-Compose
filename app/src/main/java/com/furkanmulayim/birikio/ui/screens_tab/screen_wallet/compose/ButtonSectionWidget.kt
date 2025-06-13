package com.furkanmulayim.birikio.ui.screens_tab.screen_wallet.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.component.buttons.default_buttons.CustomPrimaryButton
import com.furkanmulayim.birikio.core.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.nav.AppScreens
import com.furkanmulayim.birikio.ui.theme.AppSize

@Composable
fun ButtonSectionWidget(
    navController: NavController, buyOnClick: () -> Unit, soldOnClick: () -> Unit
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
            iconRes = R.drawable.svg_square_icon_invest_buy,
            onClick = {
                buyOnClick()
            })

        CustomSpacerWidth(4)

        // BUTTON ->Sold
        CustomPrimaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.wallet_total_outvest),
            iconRes = R.drawable.svg_square_icon_invest_sold,
            onClick = {
                soldOnClick()
            })

        CustomSpacerWidth(4)

        // BUTTON -> GRAPHİC
        CustomPrimaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.wallet_total_detail),
            iconRes = R.drawable.svg_square_icon_graphic,
            onClick = {})

        CustomSpacerWidth(4)

        // BUTTON -> IBANS
        CustomPrimaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.wallet_cards),
            iconRes = R.drawable.svg_square_icon_card,
            onClick = {
                print("BASILDIU")
                navController.navigate(AppScreens.IbanScreen.route)
            })
    }
}