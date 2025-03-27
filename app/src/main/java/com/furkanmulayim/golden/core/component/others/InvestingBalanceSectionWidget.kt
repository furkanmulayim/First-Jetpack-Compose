package com.furkanmulayim.golden.core.component.others

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CurrencyExchange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.CustomTypo


@Composable
fun InvestingBalanceSectionWidget(totalInvesting: String, isInvesting: Boolean) {
    val totalWalletText = stringResource(id = R.string.total_money)
    val totalInvestingText = stringResource(id = R.string.total_investing)
    CustomSpacerHeight(32)
    Column {
        // TEXT -> INVESTİNG
        Row {
            Text(
                text = if (isInvesting) totalInvestingText else totalWalletText,
                style = CustomTypo.text.labelLarge.copy(color = MaterialTheme.colorScheme.tertiary)
            )
            CustomSpacerWidth(8)

            // BUTTON -> SWITCH MONEY TYPE
            Box(
                Modifier
                    .size(AppSize.ButtonXSmallHeight)
                    .clip(RoundedCornerShape(AppSize.RadiusSmall))
                    .clickable { },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.CurrencyExchange,
                    tint = MaterialTheme.colorScheme.primaryContainer,
                    contentDescription = "menu",
                    modifier = Modifier.size(AppSize.ButtonMiniIconsHeight),
                )
            }
        }
        CustomSpacerHeight(4)
        // TEXT -> MONEY
        Row {
            val color = MaterialTheme.colorScheme.onSurface
            Text(
                text = totalInvesting, style = CustomTypo.text.displayLarge.copy(color)
            )
            CustomSpacerWidth(5)
            Text(
                text = "₺", style = CustomTypo.text.displayLarge.copy(color)
            )
        }
    }
}
