package com.furkanmulayim.birikio.core.component.buttons.default_buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonIconsHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonMediumIconsHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingXSmall
import com.furkanmulayim.birikio.ui.theme.Typo

@Composable
fun CustomPrimaryButton(
    text: String, iconRes: Int, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(PaddingXSmall)
            .aspectRatio(0.8f)
            .clip(RoundedCornerShape(ButtonIconsHeight))
            .background(colorScheme.secondary)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = text,
            style = Typo.font_14_w500.copy(color = colorScheme.primary),
            textAlign = TextAlign.Center,
        )
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = text,
            tint = colorScheme.primary,
            modifier = Modifier
                .size(ButtonMediumIconsHeight)
                .align(Alignment.CenterHorizontally)
        )
    }
}