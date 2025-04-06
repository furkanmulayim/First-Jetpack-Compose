package com.furkanmulayim.golden.core.component.buttons.icon_button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.twins

@Composable
fun CustomIconTextButton(icon: Int, onClick: () -> Unit, text: String) {
    Row(
        Modifier
            .clip(RoundedCornerShape(AppSize.RadiusIcons))
            .background(twins)
            .clickable { onClick() }
            .padding(AppSize.PaddingSmall),
    ) {
        Icon(
            painterResource(icon),
            tint = MaterialTheme.colorScheme.primaryContainer,
            contentDescription = "menu",
            modifier = Modifier.size(AppSize.ButtonIconsHeight),
        )
        Text(text)
    }
}