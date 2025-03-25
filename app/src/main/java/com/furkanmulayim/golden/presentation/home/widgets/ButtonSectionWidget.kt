package com.furkanmulayim.golden.presentation.home.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.furkanmulayim.golden.core.component.buttons.default_buttons.CustomPrimaryButton
import com.furkanmulayim.golden.core.component.buttons.default_buttons.CustomSecondaryButton
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth

@Composable
fun ButtonSectionWidget(
    firstText: String,
    firstIcon: Int,
    firstClick: () -> Unit,
    secondText: String,
    secondIcon: Int,
    secondClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // BUTTON -> DO INVEST BUTTON
        CustomPrimaryButton(
            modifier = Modifier.weight(1f),
            text = firstText,
            iconRes = firstIcon,
            onClick = firstClick
        )
        CustomSpacerWidth(10)

        // BUTTON -> LIVE DATA
        CustomSecondaryButton(
            modifier = Modifier.weight(1f),
            text = secondText,
            iconRes = secondIcon,
            onClick = secondClick
        )
    }
}

