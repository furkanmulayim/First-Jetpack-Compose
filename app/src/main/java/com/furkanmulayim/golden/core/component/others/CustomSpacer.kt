package com.furkanmulayim.golden.core.component.others

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomSpacerWidth(w: Int) {
    Spacer(Modifier.width(w.dp))
}

@Composable
fun CustomSpacerHeight(h: Int) {
    Spacer(Modifier.height(h.dp))
}