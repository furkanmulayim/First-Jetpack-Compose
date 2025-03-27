package com.furkanmulayim.golden.presentation.tab_main.wallet_ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.buttons.default_buttons.CustomPrimaryButton
import com.furkanmulayim.golden.core.component.buttons.default_buttons.CustomSecondaryButton
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth

@Composable
fun ButtonSectionWidget(
    navController: NavController
) {
    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        // BUTTON -> ADD
        CustomSecondaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.wallet_add),
            iconRes = null,
            onClick = {},
        )
        CustomSpacerWidth(10)

        // BUTTON -> DELETE
        CustomSecondaryButton(
            modifier = Modifier.weight(1f),
            text = stringResource(id = R.string.wallet_delete),
            iconRes = null,
            onClick = { },
        )

        CustomSpacerWidth(10)

        // BUTTON -> MY CARDS
        CustomPrimaryButton(
            modifier = Modifier.weight(1.4f),
            text = stringResource(id = R.string.my_cards),
            iconRes = R.drawable.svg_card,
            onClick = {},
        )
    }
    CustomSpacerHeight(24)
}

