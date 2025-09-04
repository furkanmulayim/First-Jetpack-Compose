package com.furkanmulayim.birikio.feature.screen_profile.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo


@SuppressLint("RememberInComposition")
@Composable
fun SettingRow(
    icon: Int,
    title: String,
    trailing: @Composable (() -> Unit)? = null,
    warningColor: Color? = null,
    onClick: (() -> Unit),
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = MutableInteractionSource()
            ) {
                onClick
            }
            .padding(vertical = Appsize.padding12, horizontal = Appsize.padding16),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(Appsize.radius4))
                .background(colorScheme.surface)
                .size(Appsize.iconSize28)
        ) {
            Icon(
                painterResource(icon),
                tint = warningColor ?: colorScheme.onPrimaryContainer,
                contentDescription = null,
                modifier = Modifier.matchParentSize()
            )
        }

        Text(
            text = title,
            style = Typo.font_15_w500.copy(color = warningColor ?: colorScheme.secondary),
            modifier = Modifier
                .weight(1F)
                .padding(horizontal = Appsize.padding8)
        )
        trailing?.invoke()
    }
}