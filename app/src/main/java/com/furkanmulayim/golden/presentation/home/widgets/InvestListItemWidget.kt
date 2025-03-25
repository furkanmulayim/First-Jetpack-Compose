package com.furkanmulayim.golden.presentation.home.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.core.extensions.getInvestNameToImage
import com.furkanmulayim.golden.models.InvestModel
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.CustomTypo

@Composable
fun InvestListItemWidget(investment: InvestModel, onClick: () -> Unit) {

    val colorScheme = MaterialTheme.colorScheme
    val theme = CustomTypo.text
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = AppSize.PaddingLarger, horizontal = AppSize.PaddingMedium),
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = investment.name.getInvestNameToImage()),
            contentDescription = "Investment Icon",
            modifier = Modifier.size(AppSize.ItemImage)
        )
        CustomSpacerWidth(12)

        Column(modifier = Modifier.weight(1f)) {
            // NAME TEXT
            Text(
                text = investment.name, style = theme.bodyMedium.copy(colorScheme.onSurface)
            )
            CustomSpacerHeight(6)
            //TOTAL TEXT
            Text(
                text = "${investment.totalPrice} ₺",
                style = theme.labelSmall.copy(colorScheme.tertiary)
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            val statusColor =
                if (investment.isBuyed) colorScheme.inversePrimary else colorScheme.inverseSurface

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // LIVE  TEXT
                Text(
                    text = "${investment.count} Adet",
                    style = theme.labelSmall.copy(statusColor)
                )
                CustomSpacerWidth(4)
                // LIVE  ICON
                Image(
                    painter = painterResource(R.drawable.svg_piece),
                    colorFilter = ColorFilter.tint(statusColor),
                    contentDescription = "Arrow Icon",
                    modifier = Modifier.size(
                        height = AppSize.ItemMiniImage, width = AppSize.ItemMiniImage
                    )
                )
            }
            CustomSpacerHeight(8)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // TIME TEXT
                Text(
                    text = "12 Haz 25",
                    style = theme.labelSmall.copy(colorScheme.tertiary)
                )
                CustomSpacerWidth(4)
                // TIME ICON
                Image(
                    painter = painterResource(R.drawable.svg_time_square),
                    contentDescription = "Tıme Icon",
                    colorFilter = ColorFilter.tint(colorScheme.tertiary),
                    modifier = Modifier.size(
                        height = AppSize.ItemMiniImage, width = AppSize.ItemMiniImage
                    )
                )
            }

        }
        CustomSpacerWidth(12)

        // BIG ARROW IMAGE
        Image(
            painter = painterResource(R.drawable.svg_big_error),
            contentDescription = "Arrow Icon",
            colorFilter = ColorFilter.tint(colorScheme.onTertiaryContainer),
            modifier = Modifier.size(
                height = AppSize.ItemMadImage, width = AppSize.ItemSmallImage
            )
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.7.dp)
            .background(color = colorScheme.onPrimaryContainer)
    )
}
