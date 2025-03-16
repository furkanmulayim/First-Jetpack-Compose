package com.furkanmulayim.golden.ui.home_screen.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.buttons.icon_button.CustomIconButton
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.ui.theme.AppSize
import com.furkanmulayim.golden.ui.theme.CustomTypo

@Composable
fun TopBar(
    meOnClick: () -> Unit = {}, cardOnClick: () -> Unit = {}, walletOnClick: () -> Unit = {}
) {
    val welcome = stringResource(id = R.string.welcome)
    val day = stringResource(id = R.string.day)
    Row(
        modifier = Modifier
            .padding(top = AppSize.PaddingXLarge)
            .fillMaxWidth()
            .height(AppSize.ButtonHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row {
            Box(
                Modifier
                    .clip(RoundedCornerShape(AppSize.RadiusMedium))
                    .clickable { meOnClick() }
                    .padding(AppSize.PaddingSmall)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        painterResource(R.drawable.svg_burger_menu),
                        tint = MaterialTheme.colorScheme.primaryContainer,
                        contentDescription = "menu",
                        modifier = Modifier.size(AppSize.ButtonIconsHeight),
                    )
                    CustomSpacerWidth(8)
                    Column {
                        Text(
                            text = welcome,
                            style = CustomTypo.text.labelSmall.copy(color = MaterialTheme.colorScheme.tertiary)
                        )
                        Text(
                            text = day,
                            style = CustomTypo.text.labelSmall.copy(color = MaterialTheme.colorScheme.tertiaryContainer)
                        )
                    }
                }
            }
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
