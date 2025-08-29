package com.furkanmulayim.birikio.feature.screen_home.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.birikio.design.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import com.furkanmulayim.birikio.design.theme.primaryContainer
import com.furkanmulayim.birikio.feature.screen_home.data.model.RateCurrency

@Composable
fun RateList(list: List<RateCurrency>) {
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = Appsize.radius16, topEnd = Appsize.radius16
                )
            )
            .background(colorScheme.primaryContainer)
            .horizontalScroll(scrollState, enabled = false)
            .clickable(
                enabled = true, onClick = { /* todo */ })
            .padding(Appsize.padding12)
    ) {
        list.forEach { item ->
            RateItem(item)
            CustomSpacerWidth(Appsize.padding16)
        }
    }
}

@Composable
private fun RateItem(rateCurrency: RateCurrency) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Appsize.padding8),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val size = Appsize
        Box(
            Modifier
                .clip(RoundedCornerShape(size.radius100))
                .size(size.iconButtonSize)
                .background(primaryContainer)
                .padding(size.padding4),
            contentAlignment = Alignment.Center,
        ) {
            Icon(
                painterResource(rateCurrency.icon),
                tint = colorScheme.secondary,
                contentDescription = rateCurrency.name,
            )
        }
        CustomSpacerWidth(Appsize.padding8)
        Column {
            Text(
                modifier = Modifier.padding(bottom = Appsize.padding4),
                text = rateCurrency.name,
                style = Typo.font_12_w500
            )
            Text(
                text = "${rateCurrency.price}₺", style = Typo.font_14_w600
            )
        }
    }
}