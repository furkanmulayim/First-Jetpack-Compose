package com.furkanmulayim.golden.ui.swap_bottom_sheet.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.furkanmulayim.golden.ui.theme.AppSize
import com.furkanmulayim.golden.ui.theme.twins_15

@Composable
fun CustomIconSwapButton(icon: Int, onClick: () -> Unit, size: Dp = AppSize.ButtonIconsHeight) {

    Box(
        Modifier
            .clip(RoundedCornerShape(AppSize.RadiusButtons))
            .background(twins_15)
            .clickable { onClick() }
            .padding(AppSize.Padding),
    ) {
        Icon(
            painterResource(icon),
            tint = colorScheme.onSecondary,
            contentDescription = "menu",
            modifier = Modifier.size(size),
        )
    }
}