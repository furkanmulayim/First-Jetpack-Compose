package com.furkanmulayim.golden.ui.home_screen.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.CustomSpacerWidth
import com.furkanmulayim.golden.core.component.buttons.icon_button.CustomIconButton
import com.furkanmulayim.golden.core.component.buttons.icon_button.CustomIconTextFlatButton
import com.furkanmulayim.golden.ui.theme.AppSize

@Composable
fun TopBar(
    meOnClick: () -> Unit = {}, cardOnClick: () -> Unit = {}, walletOnClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .padding(top = AppSize.PaddingXLarge)
            .fillMaxWidth()
            .height(AppSize.ButtonHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row {
            // ICON FLAT -> BURGER MENU
            CustomIconTextFlatButton(R.drawable.svg_burger_menu, meOnClick)
        }

        Row {
            //  ICON -> WALLET
            CustomIconButton(R.drawable.svg_wallet, walletOnClick)
            CustomSpacerWidth(8)
            //  ICON -> CREDIT CARD
            CustomIconButton(R.drawable.svg_card, walletOnClick)
        }
    }
}
