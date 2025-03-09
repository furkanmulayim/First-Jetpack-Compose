package com.furkanmulayim.golden.ui.home_screen.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Insights
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Wallet
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.CustomSpacerWidth
import com.furkanmulayim.golden.core.component.buttons.CustomIconButton
import com.furkanmulayim.golden.core.component.buttons.CustomIconTextButton
import com.furkanmulayim.golden.ui.theme.AppSize

@Composable
fun TopBar(
    meOnClick: () -> Unit = {},
    cardOnClick: () -> Unit = {},
    walletOnClick: () -> Unit = {}
) {

    val wallet = stringResource(id = R.string.wallet)
    Row(
        modifier = Modifier
            .padding(top = AppSize.PaddingXXXLarge)
            .fillMaxWidth()
            .height(AppSize.ButtonHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row {
            // ICON -> PROFILE
            CustomIconButton(Icons.Rounded.Person, meOnClick)
            CustomSpacerWidth(8)
            // ICON -> CREDIT CARD
            CustomIconButton(Icons.Rounded.Wallet, cardOnClick)
        }
        // TEXT ICON -> WALLET
        CustomIconTextButton(Icons.Rounded.Insights, wallet, walletOnClick)
    }
}
