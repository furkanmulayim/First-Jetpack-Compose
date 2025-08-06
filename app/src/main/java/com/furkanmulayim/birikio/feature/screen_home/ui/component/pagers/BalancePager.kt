package com.furkanmulayim.birikio.feature.screen_home.ui.component.pagers


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.buttons.CustomIconButtonUnderText
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

@Composable
fun BalancePager(
) {

    val balanceMoney = 345_624.0 // todo viewModel’den gelecek

    val formatted = remember(balanceMoney) {
        NumberFormat.getCurrencyInstance(Locale("tr", "TR")).apply {
            currency = Currency.getInstance("TRY")
            maximumFractionDigits = 0
        }.format(balanceMoney)
    }

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
            .clip(RoundedCornerShape(Appsize.radius12))
            .background(colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
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
            Text(
                modifier = Modifier.padding(top = Appsize.padding6, bottom = Appsize.padding8),
                text = "Varlıklarım",
                style = Typo.font_16_w500,
                color = colorScheme.onPrimaryContainer
            )
            Text(
                text = formatted, // örn: ₺345.624
                style = Typo.font_43_w800
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Appsize.padding8, bottom = Appsize.padding6),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CustomIconButtonUnderText(
                    icon = R.drawable.balance_total, text = textBalance, onClick = {})

                CustomIconButtonUnderText(
                    icon = R.drawable.balance_history, text = textDetail, onClick = {})

                CustomIconButtonUnderText(
                    icon = R.drawable.balance_buy, text = textBuy, onClick = {})

                CustomIconButtonUnderText(
                    icon = R.drawable.balance_sold, text = textSold, onClick = {})
            }
        }
    }
}