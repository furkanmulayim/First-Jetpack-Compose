package com.furkanmulayim.golden.core.component.others

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.extensions.curencyFormat
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.CustomTypo
import com.furkanmulayim.golden.presentation.theme.twins


@Composable
fun InvestingBalanceSectionWidget(totalInvesting: String, isInvesting: Boolean) {
    val totalWalletText = stringResource(id = R.string.total_money)
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
                text = totalWalletText,
                style = CustomTypo.miniBold.copy(
                    color = twins,
                    letterSpacing = 2.sp
                )
            )
            CustomSpacerHeight(12)
            // TEXT -> MONEY
            Row {
                val color = MaterialTheme.colorScheme.primary
                Text(
                    text = "₺", style = CustomTypo.text.displayLarge.copy(color = color)
                )
                CustomSpacerWidth(5)
                Text(
                    text = totalInvesting.curencyFormat(),
                    style = CustomTypo.text.displayLarge.copy(color)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                val color = twins
                Text(
                    text = "+₺", style = CustomTypo.text.bodyLarge.copy(color = color)
                )
                Text(
                    text = "1612,32".curencyFormat(), style = CustomTypo.text.bodyLarge.copy(color)
                )

                CustomSpacerWidth(8)
                val colorGreenAndRed = MaterialTheme.colorScheme.onTertiary
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(AppSize.RadiusIcons))
                        .background(color = MaterialTheme.colorScheme.tertiary)
                        .padding(vertical = 6.dp, horizontal = 8.dp)
                ) {
                    Row {
                        Text(
                            text = "+", style = CustomTypo.text.bodyMedium.copy(colorGreenAndRed)
                        )
                        Text(
                            text = "2.17%",
                            style = CustomTypo.text.bodyMedium.copy(colorGreenAndRed)
                        )
                    }

                }

            }
        }
    }
}
