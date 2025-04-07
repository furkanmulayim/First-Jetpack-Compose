package com.furkanmulayim.golden.presentation.tab_main.investing_ui.widget

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
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.core.extensions.curencyFormat
import com.furkanmulayim.golden.core.extensions.getInvestNameToImage
import com.furkanmulayim.golden.models.InvestModel
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.Typo
import com.furkanmulayim.golden.presentation.theme.twins
import com.furkanmulayim.golden.presentation.theme.twins_60

@Composable
fun InvestListItemWidget(investment: InvestModel, onClick: () -> Unit) {

    val colorScheme = MaterialTheme.colorScheme

    val (statusColor, statusText) = if (investment.isBuyed) {
        colorScheme.onTertiary to "+"
    } else {
        colorScheme.inverseSurface to "-"
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(vertical = AppSize.Padding, horizontal = AppSize.PaddingSmall),
        verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = investment.name.getInvestNameToImage()),
            contentDescription = "Investment Icon",
            modifier = Modifier.size(AppSize.ButtonHeight)
        )
        CustomSpacerWidth(12)

        Column(modifier = Modifier.weight(1f)) {
            // NAME TEXT
            Text(
                text = investment.name, style = Typo.font_15_w500.copy(colorScheme.scrim)
            )
            CustomSpacerHeight(6)
            //TOTAL TEXT

            Row {
                Text(
                    text = "${investment.currentPrice.curencyFormat()}₺",
                    style = Typo.font_13_w500.copy(twins)
                )
                CustomSpacerWidth(4)
                Text( // todo hardoce olarak yazıldı değiştirilecek
                    text = "$statusText${0.18}%",
                    style = Typo.font_13_w500.copy(statusColor)
                )
            }
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "$statusText${investment.count} Adet",
                style = Typo.font_15_w500.copy(statusColor)
            )

            CustomSpacerHeight(6)
            Text(
                text = "~${investment.totalPrice.curencyFormat()}₺",
                style = Typo.font_13_w500.copy(twins)
            )
        }
        CustomSpacerWidth(18)

        // BIG ARROW IMAGE
        Image(
            painter = painterResource(R.drawable.svg_big_error),
            contentDescription = "Arrow Icon",
            colorFilter = ColorFilter.tint(twins_60),
            modifier = Modifier.size(
                height = AppSize.ItemMadImage, width = AppSize.ItemSmallImage
            )
        )
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(AppSize.one_dp)
            .background(color = colorScheme.secondary)
    )
}
