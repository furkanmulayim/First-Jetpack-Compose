package com.furkanmulayim.birikio.design.component.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
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
import com.furkanmulayim.birikio.design.theme.transparent40


@Composable
fun CustomIconButtonUnderText(icon: Int, text: String, onClick: () -> Unit) {
    val size = Appsize
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(size.radius12))
                .width(size.bottomTextIConButtonSize)
                .wrapContentHeight()
                .background(transparent40)
                .clickable { onClick() }
                .padding(size.padding8),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painterResource(icon),
                tint = Color.White,
                contentDescription = "menu",
            )
        }
        Text(
            modifier = Modifier.padding(top = Appsize.padding8),
            text = text,
            style = Typo.font_12_w500,
            color = colorScheme.inverseSurface,
            maxLines = 1
        )
    }

}