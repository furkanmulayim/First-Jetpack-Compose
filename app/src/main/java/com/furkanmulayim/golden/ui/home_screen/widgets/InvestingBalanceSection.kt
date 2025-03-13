package com.furkanmulayim.golden.ui.home_screen.widgets

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
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.ui.theme.AppSize
import com.furkanmulayim.golden.ui.theme.CustomTypo
import com.furkanmulayim.golden.ui.theme.white400


@Composable
fun InvestingBalanceSection(totalInvesting: String) {
    val totalInvestingText = stringResource(id = R.string.total_investing)
    CustomSpacerHeight(24)
    Column {
        // TEXT -> INVESTİNG
        Row {
            Text(
                text = totalInvestingText, style = CustomTypo.text.labelSmall.copy(color = white400)
            )
            CustomSpacerWidth(5)

            // BUTTON -> SWITCH MONEY TYPE
            Box(
                Modifier
                    .size(AppSize.ButtonXSmallHeight)
                    .clip(RoundedCornerShape(AppSize.RadiusSmall))
                    .clickable { },
                contentAlignment = androidx.compose.ui.Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Rounded.CurrencyExchange,
                    tint = MaterialTheme.colorScheme.tertiaryContainer,
                    contentDescription = "menu",
                    modifier = Modifier.size(AppSize.ButtonMiniIconsHeight),
                )
            }
        }
        // TEXT -> MONEY
        Row {
            Text(
                text = totalInvesting,
                style = CustomTypo.text.displayLarge.copy(color = MaterialTheme.colorScheme.tertiary)
            )
            CustomSpacerWidth(5)
            Text(
                text = "₺",
                style = CustomTypo.text.displayLarge.copy(color = MaterialTheme.colorScheme.tertiary)
            )
        }
    }
}
