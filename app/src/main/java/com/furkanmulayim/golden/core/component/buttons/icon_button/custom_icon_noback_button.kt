package com.furkanmulayim.golden.core.component.buttons.icon_button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import com.furkanmulayim.golden.presentation.theme.AppSize

@Composable
fun CustomIconNoBackButton(icon: Int, onClick: () -> Unit, size: Dp = AppSize.ButtonIconsHeight) {
    Box(
        Modifier
            .clip(RoundedCornerShape(AppSize.RadiusIcons))
            .clickable { onClick() }
            .padding(AppSize.PaddingSmall),
    ) {
        Icon(
            painterResource(icon),
            tint = MaterialTheme.colorScheme.primaryContainer,
            contentDescription = "menu",
            modifier = Modifier.size(size),
        )
    }
}