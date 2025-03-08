package com.furkanmulayim.golden.ui.home_screen.widgets

import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.constants.component.SpacedHeight
import com.furkanmulayim.golden.core.constants.component.SpacedWidth
import com.furkanmulayim.golden.ui.theme.AppSize
import com.furkanmulayim.golden.ui.theme.CustomTypo


@Composable
fun InvestingBalanceSection(totalInvesting: String) {
    val totalInvestingText = stringResource(id = R.string.total_investing)
    SpacedHeight(24)
    Column {
        // TEXT -> INVESTİNG
        Row {
            Text(
                text = totalInvestingText,
                style = CustomTypo.text.labelLarge.copy(color = MaterialTheme.colorScheme.tertiaryContainer)
            )
            SpacedWidth(5)

            // BUTTON -> SWITCH MONEY TYPE
            Box(
                Modifier
                    .size(AppSize.ButtonXSmallHeight)
                    .clip(RoundedCornerShape(AppSize.RadiusSmall))
                    .background(MaterialTheme.colorScheme.surface)
                    .clickable { }
            ) {
                Icon(
                    imageVector = Icons.Rounded.CurrencyExchange,
                    tint = MaterialTheme.colorScheme.tertiaryContainer,
                    contentDescription = "menu"
                )
            }
        }
        // TEXT -> MONEY
        Row {
            Text(
                text = totalInvesting,
                style = CustomTypo.text.displayLarge.copy(color = MaterialTheme.colorScheme.tertiary)
            )
            SpacedWidth(5)
            Text(
                text = "₺",
                style = CustomTypo.text.displayLarge.copy(color = MaterialTheme.colorScheme.tertiary)
            )
        }
    }
}
