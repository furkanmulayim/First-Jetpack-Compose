package com.furkanmulayim.birikio.feature.screen_home.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.design.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo

@Composable
fun DoubleButtons(
    leftOnClick: () -> Unit, rightOnClick: () -> Unit
) {

    val leftText = "Hedeflerim"
    val leftDescText = "Kişisel Belirlenen"
    val leftIcon = R.drawable.twins_button_left

    val rightText = "Cüzdanım"
    val rightDescText = "Kart ve Hesaplar"
    val rightIcon = R.drawable.twins_button_right

    val weight = 1F
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = Appsize.padding16)
    ) {
        ButtonItem(
            leftOnClick, modifier = Modifier.weight(weight), leftText, leftDescText, leftIcon
        )
        CustomSpacerWidth(Appsize.padding12)
        ButtonItem(
            rightOnClick, modifier = Modifier.weight(weight), rightText, rightDescText, rightIcon
        )
    }
}

@Composable
private fun ButtonItem(
    onClick: () -> Unit, modifier: Modifier = Modifier, text: String, desc: String, icon: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Appsize.radius16))
            .height(Appsize.doubleButtonSize)
            .background(colorScheme.primaryContainer)
            .border(0.5.dp, colorScheme.outline, RoundedCornerShape(Appsize.radius16))
            .clickable(
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Column(
            modifier = Modifier.padding(start = Appsize.padding14)
        ) {
            Text(text = text, style = Typo.font_14_w600)
            CustomSpacerHeight(Appsize.size3)
            Text(text = desc, style = Typo.font_12_w500)
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(Appsize.radius16))
                .fillMaxHeight()
                .background(colorScheme.primaryContainer), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(Appsize.doubleButtonSize)
            )
        }
    }
}