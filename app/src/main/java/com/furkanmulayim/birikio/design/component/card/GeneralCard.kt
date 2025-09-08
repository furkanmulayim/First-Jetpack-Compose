package com.furkanmulayim.birikio.design.component.card

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.design.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.design.theme.Appsize

@Composable
fun GeneralCard(view: @Composable () -> Unit) {
    CustomSpacerHeight(Appsize.padding20)
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(Appsize.radius16))
            .background(colorScheme.primaryContainer)
            .border(0.5.dp, colorScheme.outline, RoundedCornerShape(Appsize.radius16))

    ) {
        view()
    }
}

@Composable
fun GeneralCardShortPaddings(view: @Composable () -> Unit) {
    CustomSpacerHeight(Appsize.padding10)
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(Appsize.radius16))
            .background(colorScheme.primaryContainer)
            .border(0.5.dp, colorScheme.outline, RoundedCornerShape(Appsize.radius16))

    ) {
        view()
    }
}

@Composable
fun GeneralCardNoPaddings(view: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(Appsize.radius16))
            .background(colorScheme.primaryContainer)
            .border(0.5.dp, colorScheme.outline, RoundedCornerShape(Appsize.radius16))

    ) {
        view()
    }
}


