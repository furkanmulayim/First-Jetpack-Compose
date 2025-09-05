package com.furkanmulayim.birikio.feature.screen_profile.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomHorizontalDivider

@Composable
fun AccessibilityContent(onClickPassword: () -> Unit, onClickLanguage: () -> Unit) {

    var isPinChecked by remember { mutableStateOf(false) }
    var isLangChecked by remember { mutableStateOf(false) }

    SettingRow(
        icon = R.drawable.settings_pin, title = "Pin Kodu Sor", trailing = {
            CustomSwitch(
                isChecked = isPinChecked, onCheckedChange = { isPinChecked = it })
        }, onClick = onClickPassword
    )
    CustomHorizontalDivider()
    SettingRow(
        icon = R.drawable.settings_language, title = "Uygulama Dili", trailing = {
            CustomSwitch(
                isChecked = isLangChecked,
                onCheckedChange = { isLangChecked = it },
                isLanguage = true
            )
        }, onClick = onClickLanguage
    )
}