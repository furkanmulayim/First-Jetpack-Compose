package com.furkanmulayim.golden.core.component.buttons.icon_button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.furkanmulayim.golden.ui.theme.AppSize

@Composable
fun CustomIconFlatButton(icon: ImageVector, onClick: () -> Unit) {
    Box(
        Modifier
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