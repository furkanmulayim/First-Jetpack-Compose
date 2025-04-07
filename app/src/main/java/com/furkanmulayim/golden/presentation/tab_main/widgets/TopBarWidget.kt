package com.furkanmulayim.golden.presentation.tab_main.widgets

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.golden.R

@Composable
fun TopBarWidget(
    today: String,
    meOnClick: () -> Unit = {},
    settingOnClick: () -> Unit = {},
) {
    stringResource(id = R.string.welcome)

}
