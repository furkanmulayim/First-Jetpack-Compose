package com.furkanmulayim.birikio.ui.screens_tab.screen_wallet.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.core.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.core.extensions.curencyFormat
import com.furkanmulayim.birikio.ui.theme.AppSize
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.twins


@Composable
fun WalletBalanceSectionWidget(totalInvesting: String, isInvesting: Boolean) {
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
                    text = totalInvesting.curencyFormat(),
                    style = Typo.font_46_w800.copy(color)
                )
            }
        }
    }
}
