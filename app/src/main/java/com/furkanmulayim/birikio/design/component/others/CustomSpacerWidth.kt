package com.furkanmulayim.birikio.design.component.others

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun CustomSpacerWidth(w: Dp) {
    Spacer(Modifier.width(w))
}

@Composable
fun CustomSpacerHeight(h: Dp) {
    Spacer(Modifier.height(h))
}