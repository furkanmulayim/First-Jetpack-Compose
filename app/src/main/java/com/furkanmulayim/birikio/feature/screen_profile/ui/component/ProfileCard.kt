package com.furkanmulayim.birikio.feature.screen_profile.ui.component

import RightArrowOpen
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.design.component.buttons.CustomProfileButton
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo

@Composable
fun ProfileCard(
    title: String, subtitle: String?, iconResId: Int, onProfileClick: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(Appsize.radius16))
            .background(colorScheme.primaryContainer)
            .border(0.5.dp, colorScheme.outline, RoundedCornerShape(Appsize.radius16))
            .clickable(enabled = onProfileClick != null) {
                onProfileClick?.invoke()
            },
    ) {
        Row(
            modifier = Modifier
                .padding(
                    vertical = Appsize.padding12, horizontal = Appsize.padding16
                )
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
        ) {
            CustomProfileButton(
                icon = iconResId, sized = 60, onClick = null
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = Appsize.padding10)
                    .weight(1F),
            ) {
                Text(
                    modifier = Modifier.padding(bottom = if (subtitle != null) Appsize.size3 else Appsize.zero),
                    text = title,
                    style = Typo.font_22_w700
                )
                if (subtitle != null) {
                    Text(
                        text = subtitle, style = Typo.font_12_w500
                    )
                }
            }
            RightArrowOpen()
        }
    }
}