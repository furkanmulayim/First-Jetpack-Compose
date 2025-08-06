package com.furkanmulayim.birikio.design.component.others

import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.design.theme.transparent40

@Composable
fun CustomHorizontalDivider() {

    HorizontalDivider(
        color = transparent40, thickness = 0.5.dp
    )
}