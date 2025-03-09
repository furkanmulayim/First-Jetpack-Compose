package com.furkanmulayim.golden.core.component.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import com.furkanmulayim.golden.ui.theme.AppSize

@Composable
fun CustomIconButton(icon: ImageVector, onClick: () -> Unit) {
    Box(
        Modifier
            .clip(RoundedCornerShape(AppSize.RadiusMedium))
            .background(MaterialTheme.colorScheme.surface)
            .clickable { onClick() }
            .padding(AppSize.PaddingSmall),
    ) {
        Icon(
            imageVector = icon,
            tint = MaterialTheme.colorScheme.onSecondaryContainer,
            contentDescription = "menu"
        )
    }
}