package com.furkanmulayim.birikio.ui.tab_pages.tab_wallet_ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.core.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.model.InvestModel
import com.furkanmulayim.birikio.ui.theme.AppSize
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.blued
import com.furkanmulayim.birikio.ui.theme.greened
import com.furkanmulayim.birikio.ui.theme.oranged
import com.furkanmulayim.birikio.ui.theme.pinked
import com.furkanmulayim.birikio.ui.theme.soldLight
import com.furkanmulayim.birikio.ui.theme.twins_15
import com.furkanmulayim.birikio.ui.theme.twins_40

@Composable
fun WalletListItemWidget(investment: InvestModel, onClick: () -> Unit) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(
                color = twins_15, shape = RoundedCornerShape(AppSize.RadiusMedium)
            )
            .padding(
                horizontal = AppSize.PaddingMedium, vertical = AppSize.Padding
            ), verticalAlignment = Alignment.CenterVertically) {

        // Sol image
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    brush = androidx.compose.ui.graphics.Brush.Companion.linearGradient(
                        if (investment.isBuyed) listOf(oranged, pinked) else listOf(greened, blued)

                    ), shape = androidx.compose.foundation.shape.CircleShape
                ), contentAlignment = Alignment.Center
        ) {

            val paraBirimi = "$" // todo $, €, ₺ gibi değerler gelecek.
            Text(
                text = paraBirimi,
                style = Typo.font_25_w800.copy(
                    color = colorScheme.secondary
                ),
                modifier = Modifier.offset(y = AppSize.two_dp) // fonttan dolayı üstte durmasını engeller, ortalar.
            )

        }

        CustomSpacerWidth(8)

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "title", style = Typo.font_15_w500.copy(color = colorScheme.primary)
            )
            CustomSpacerHeight(4)
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .background(
                            color = twins_40, shape = RoundedCornerShape(AppSize.RadiusSmall)
                        )
                        .padding(
                            horizontal = AppSize.PaddingSmall, vertical = AppSize.PaddingXSmall
                        )
                ) {
                    Text(
                        text = "category",
                        style = Typo.font_13_w500.copy(color = colorScheme.onSurface)
                    )
                }
                CustomSpacerWidth(12)
            }
        }

        Column(
            modifier = Modifier.padding(end = AppSize.zero_dp), horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "date", style = Typo.font_14_w500.copy(color = colorScheme.onSurface)
            )
            CustomSpacerHeight(4)
            val (color, moneyType) = if (investment.isBuyed) {
                greened to "+"
            } else {
                soldLight to "-"
            }
            Text(
                text = "${moneyType}500 TL", style = Typo.font_19_w300.copy(), color = color
            )
        }
    }
    CustomSpacerHeight(12)
}

