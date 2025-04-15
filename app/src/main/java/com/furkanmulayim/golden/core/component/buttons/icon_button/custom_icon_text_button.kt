package com.furkanmulayim.golden.core.component.buttons.icon_button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.presentation.theme.AppSize

@Composable
fun CustomIconTextButton(
    icon: Int, onClick: () -> Unit, text: String, isRightIcon: Boolean = false
) {
    Row(
        Modifier
            .clip(RoundedCornerShape(AppSize.RadiusIcons))
            .background(MaterialTheme.colorScheme.secondary)
            .clickable { onClick() }
            .padding(AppSize.PaddingSmall),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {

        if (isRightIcon) {
            CustomSpacerWidth(4)
            Text(text, style = MaterialTheme.typography.bodyMedium)
            CustomSpacerWidth(4)
            Icon(
                painterResource(icon),
                tint = MaterialTheme.colorScheme.onSecondary,
                contentDescription = "menu",
                modifier = Modifier.size(AppSize.ButtonIconsHeight),
            )
            CustomSpacerWidth(4)
        } else {
            CustomSpacerWidth(4)
            Icon(
                painterResource(icon),
                tint = MaterialTheme.colorScheme.onSecondary,
                contentDescription = "menu",
                modifier = Modifier.size(AppSize.ButtonIconsHeight),
            )
            CustomSpacerWidth(4)
            Text(text, style = MaterialTheme.typography.bodyMedium)
            CustomSpacerWidth(4)
        }

    }
}