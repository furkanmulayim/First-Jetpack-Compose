package com.furkanmulayim.birikio.design.component.app_bar

import CustomIconButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomHorizontalDivider
import com.furkanmulayim.birikio.design.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.design.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo

@Composable
fun AppBarSection(
    name: String,
    description: String? = null,
    onBackClick: () -> Unit,
    rightIconRes: Int? = null,
    onRightIconClick: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Appsize.padding12),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CustomIconButton(
                R.drawable.back_button,
                color = colorScheme.surfaceVariant,
                onClick = onBackClick
            )
            CustomSpacerWidth(Appsize.padding8)
            if (description == null) {
                Text(text = name, style = Typo.font_19_w800)
            } else {
                Column {
                    Text(
                        modifier = Modifier.padding(bottom = Appsize.padding4),
                        text = name,
                        style = Typo.font_19_w800
                    )
                    Text(
                        text = description, style = Typo.font_16_w500
                    )
                }
            }
        }
        if (onRightIconClick != null && rightIconRes != null) CustomIconButton(
            rightIconRes, onClick = onRightIconClick
        )
    }
    CustomSpacerHeight(Appsize.padding12)
    CustomHorizontalDivider()
}
