package com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.component

import RightArrowOpen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.birikio.core.util.enums.CurrencyShortName
import com.furkanmulayim.birikio.design.component.card.GeneralCardShortPaddings
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import com.furkanmulayim.birikio.design.theme.primaryContainer
import com.furkanmulayim.birikio.feature.screen_home.data.model.RateCurrency

@Composable
fun RateCourContent(item: RateCurrency, onItemClick: () -> Unit) {
    GeneralCardShortPaddings {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick()
                }
                .padding(vertical = Appsize.padding10)
                .padding(horizontal = Appsize.padding10),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            val imageRes = CurrencyShortName.getImage(item.code)
            Image(
                painter = painterResource(imageRes),
                contentDescription = null,
                colorFilter = ColorFilter.tint(colorScheme.secondary),
                modifier = Modifier
                    .size(Appsize.iconButtonSize)
                    .clip(RoundedCornerShape(Appsize.radius12))
                    .background(primaryContainer)
            )

            Text(
                text = item.name,
                style = Typo.font_16_w500,
                modifier = Modifier.padding(start = Appsize.padding20)
            )

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "${item.price}₺",
                style = Typo.font_15_w600,
                modifier = Modifier.padding(end = Appsize.padding20)
            )

            RightArrowOpen()
        }
    }
}