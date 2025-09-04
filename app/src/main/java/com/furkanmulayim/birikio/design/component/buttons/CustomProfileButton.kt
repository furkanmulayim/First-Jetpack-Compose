package com.furkanmulayim.birikio.design.component.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.design.theme.Appsize


@Composable
fun CustomProfileButton(
    icon: Int, onClick: (() -> Unit?)?, sized: Int = 0,
) {
    val size = Appsize
    Box(
        Modifier
            .clip(RoundedCornerShape(size.radius100))
            .size(if (sized > 0) sized.dp else size.profileButtonSize)
            .background(colorScheme.onPrimaryContainer)
            .clickable(
                enabled = onClick != null
            ) {
                onClick?.invoke()
            }
            .padding(size.padding8),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painterResource(icon),
            tint = Color.Unspecified,
            contentDescription = null,
        )
    }
}
