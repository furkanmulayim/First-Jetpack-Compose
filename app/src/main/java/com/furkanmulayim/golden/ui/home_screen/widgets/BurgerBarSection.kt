package com.furkanmulayim.golden.ui.home_screen.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Insights
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import com.furkanmulayim.golden.core.constants.component.SpacedWidth
import com.furkanmulayim.golden.ui.theme.AppSize

@Composable
fun BurgerBarSection(
    leftIcon: ImageVector = Icons.Rounded.Menu,
    rightIcon: ImageVector = Icons.Rounded.Insights,
    showLeftIcon: Boolean = true,
    showRightIcon: Boolean = true,
    onLeftIconClick: () -> Unit = {},
    onRightIconClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .padding(top = AppSize.PaddingXXXLarge)
            .fillMaxWidth()
            .height(AppSize.ButtonHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (showLeftIcon) {
            IconButton(leftIcon, onLeftIconClick)
        } else {
            SpacedWidth(0)
        }

        if (showRightIcon) {
            IconButton(rightIcon, onRightIconClick)
        } else {
            SpacedWidth(0)
        }
    }
}

@Composable
private fun IconButton(icon: ImageVector, onClick: () -> Unit) {
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