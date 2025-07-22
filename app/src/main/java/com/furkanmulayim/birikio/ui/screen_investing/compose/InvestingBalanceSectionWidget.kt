package com.furkanmulayim.birikio.ui.screen_investing.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.core.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.core.extensions.currencyFormat
import com.furkanmulayim.birikio.ui.theme.AppSize
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.twins


@Composable
fun InvestingBalanceSectionWidget(totalInvesting: String, isInvesting: Boolean) {
    val totalMoneyText = stringResource(id = R.string.total_money)
    CustomSpacerHeight(24)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AppSize.PaddingLarge),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            // TEXT -> INVESTİNG
            Text(
                text = totalMoneyText,
                style = Typo.font_11_w800.copy(
                    color = twins,
                    letterSpacing = 2.sp
                )
            )
            CustomSpacerHeight(12)
            // TEXT -> MONEY
            Row {
                val color = colorScheme.primary
                Text(
                    text = "₺", style = Typo.font_46_w800.copy(color = color)
                )
                CustomSpacerWidth(5)
                Text(
                    text = totalInvesting.currencyFormat(),
                    style = Typo.font_46_w800.copy(color)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val color = twins
                Text(
                    text = "+₺", style = Typo.font_19_w500.copy(color = color)
                )
                Text(
                    text = "1612,32".currencyFormat(), style = Typo.font_19_w500.copy(color)
                )

                CustomSpacerWidth(8)
                val colorGreenAndRed = colorScheme.onTertiary
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(AppSize.RadiusIcons))
                        .background(color = colorScheme.tertiary)
                        .padding(vertical = 6.dp, horizontal = 8.dp)
                ) {
                    Row {
                        Text(
                            text = "+", style = Typo.font_16_w500.copy(colorGreenAndRed)
                        )
                        Text(
                            text = "2.17%",
                            style = Typo.font_16_w500.copy(colorGreenAndRed)
                        )
                    }

                }

            }
        }
    }
}
