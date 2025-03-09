package com.furkanmulayim.golden.core.component.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import com.furkanmulayim.golden.core.component.CustomSpacerWidth
import com.furkanmulayim.golden.ui.theme.AppSize
import com.furkanmulayim.golden.ui.theme.CustomTypo

@Composable
fun CustomIconTextButton(icon: ImageVector, text: String, onClick: () -> Unit) {
    val isEnabled = remember { mutableStateOf(true) }

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(AppSize.RadiusMedium))
            .background(
                MaterialTheme.colorScheme.surface
            )
            .clickable(enabled = isEnabled.value) {
                isEnabled.value = false
                onClick()
            }
            .padding(AppSize.PaddingSmall),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        CustomSpacerWidth(4)
        Icon(
            imageVector = icon,
            tint = if (isEnabled.value) MaterialTheme.colorScheme.onSecondaryContainer
            else MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.5f),
            contentDescription = "icon"
        )
        CustomSpacerWidth(8)
        Text(
            text = text,
            style = CustomTypo.text.labelLarge,
            color = if (isEnabled.value) MaterialTheme.colorScheme.onSecondaryContainer
            else MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.5f)
        )
        CustomSpacerWidth(4)
    }
}