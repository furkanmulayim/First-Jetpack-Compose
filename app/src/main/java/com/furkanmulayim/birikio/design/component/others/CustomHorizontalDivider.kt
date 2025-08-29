package com.furkanmulayim.birikio.design.component.others

import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun CustomHorizontalDivider() {

    HorizontalDivider(
        color = colorScheme.outline, thickness = 0.5.dp
    )
}