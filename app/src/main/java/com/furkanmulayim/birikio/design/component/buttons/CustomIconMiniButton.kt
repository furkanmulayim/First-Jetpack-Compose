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
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.birikio.design.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.design.theme.Appsize


@Composable
fun CustomIconMiniButton(icon: Int, onClick: () -> Unit) {
    CustomSpacerWidth(Appsize.size4)
    Box(
        Modifier
            .size(Appsize.iconButtonSize)
            .background(colorScheme.primaryContainer)
            .clip(RoundedCornerShape(Appsize.radius12))
            .clickable { onClick() }
            .padding(Appsize.padding6),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painterResource(icon),
            tint = colorScheme.primary,
            contentDescription = "button",
        )
    }
    CustomSpacerWidth(Appsize.size4)
}