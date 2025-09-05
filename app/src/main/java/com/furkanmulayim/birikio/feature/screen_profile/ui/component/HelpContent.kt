package com.furkanmulayim.birikio.feature.screen_profile.ui.component

import androidx.compose.runtime.Composable
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomHorizontalDivider


@Composable
fun HelpContent(
    onClickDeveloper: () -> Unit,
    onClickShareApp: () -> Unit,
    onClickPrivacy: () -> Unit,
) {
    SettingRow(
        icon = R.drawable.settings_developer,
        title = "Geliştirici Hakkında",
        onClick = onClickDeveloper
    )
    CustomHorizontalDivider()
    SettingRow(
        icon = R.drawable.settings_share, title = "Uygulamayı Paylaş", onClick = onClickShareApp
    )
    CustomHorizontalDivider()
    SettingRow(
        icon = R.drawable.settings_kvkk,
        title = "KVKK ve Gizlilik Sözleşmesi",
        onClick = onClickPrivacy
    )
}