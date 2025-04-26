package com.furkanmulayim.golden.core.component.others

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.furkanmulayim.golden.ui.theme.AppSize
import com.furkanmulayim.golden.ui.theme.twins_40

@Composable
fun CustomLine(width: Dp) {
    Row(
        modifier = Modifier
            .width(width)
            .height(AppSize.one_dp)
            .background(color = twins_40)
    ) {}
}