package com.furkanmulayim.birikio.feature.screen_profile.ui.component

import RightArrowOpen
import androidx.compose.runtime.Composable
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomHorizontalDivider
import com.furkanmulayim.birikio.design.theme.solded

@Composable
fun DeleteContent(onClickForgotPass: () -> Unit, onClickDeleteData: () -> Unit) {

    SettingRow(
        icon = R.drawable.settings_reload_pin,
        title = "Şifremi Unuttum",
        trailing = { RightArrowOpen() },
        warningColor = solded,
        onClick = onClickForgotPass
    )
    CustomHorizontalDivider()
    SettingRow(
        icon = R.drawable.settings_delete_data,
        title = "Tüm Verileri Temizle",
        trailing = { RightArrowOpen() },
        warningColor = solded,
        onClick = onClickDeleteData
    )
}