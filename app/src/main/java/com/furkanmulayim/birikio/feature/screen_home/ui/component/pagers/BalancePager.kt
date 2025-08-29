package com.furkanmulayim.birikio.feature.screen_home.ui.component.pagers


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.buttons.CustomIconButtonUnderText
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo

@Composable
fun BalancePager(
) {

    val balanceMoney = 345.624 // todo viewModel’den gelecek

    var isBalanceVisible by remember { mutableStateOf(true) }

    val textBalance = stringResource(R.string.balanceButtonBalance)
    val textDetail = stringResource(R.string.balanceButtonDetail)
    val textBuy = stringResource(R.string.balanceButtonBuy)
    val textSold = stringResource(R.string.balanceButtonSold)

    Box(
        modifier = Modifier
            .padding(top = Appsize.padding20)
            .fillMaxWidth()
            .height(Appsize.balancePagerSize)
            .padding(horizontal = Appsize.padding20)
            .clip(RoundedCornerShape(Appsize.radius16))
            .background(colorScheme.primaryContainer)
            .border(
                width = 1.dp,
                color = colorScheme.outline,
                shape = RoundedCornerShape(Appsize.radius16)
            ), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.svg_dark_balance),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier.padding(
                start = Appsize.padding16,
                end = Appsize.padding16,
                top = Appsize.padding12,
                bottom = Appsize.padding12
            )
        ) {
            Row {
                Text(
                    modifier = Modifier.padding(top = Appsize.padding6, bottom = Appsize.padding8),
                    text = "Varlıklarım",
                    style = Typo.font_16_w500,
                    color = colorScheme.onPrimaryContainer
                )
                Icon(
                    painter = painterResource(
                        if (isBalanceVisible) R.drawable.eye_button_active else R.drawable.eye_button_inactive
                    ),
                    tint = colorScheme.primary,
                    contentDescription = "Show balance",
                    modifier = Modifier
                        .size(Appsize.size24)
                        .padding(start = Appsize.padding8)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }

                        ) { isBalanceVisible = !isBalanceVisible })
            }
            Text(
                text = if (isBalanceVisible) "$balanceMoney₺" else "*** *** ₺",
                style = Typo.font_43_w800
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Appsize.padding8, bottom = Appsize.padding6),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CustomIconButtonUnderText(
                    icon = R.drawable.balance_button_total, text = textBalance, onClick = {})

                CustomIconButtonUnderText(
                    icon = R.drawable.balance_button_history, text = textDetail, onClick = {})

                CustomIconButtonUnderText(
                    icon = R.drawable.balance_button_buy, text = textBuy, onClick = {})

                CustomIconButtonUnderText(
                    icon = R.drawable.balance_button_sold, text = textSold, onClick = {})
            }
        }
    }
}