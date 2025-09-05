package com.furkanmulayim.birikio.feature.screen_home.ui.component

import CustomIconButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomHorizontalDivider
import com.furkanmulayim.birikio.design.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.design.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo

@Composable
fun HomeAppBarSection(
    name: String, onProfileClick: () -> Unit,
) {
    val textWelcomeBack = stringResource(R.string.welcomeBack)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Appsize.padding20),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            CustomIconButton(R.drawable.profile, onClick = null, isProfile = true)
            CustomSpacerWidth(Appsize.padding8)
            Column {
                Text(
                    modifier = Modifier.padding(bottom = Appsize.padding4),
                    text = "$name 👻",
                    style = Typo.font_19_w800
                )
                Text(
                    text = textWelcomeBack, style = Typo.font_16_w500
                )
            }
        }
        CustomIconButton(R.drawable.home_button_settings, onClick = onProfileClick)
    }
    CustomSpacerHeight(Appsize.padding12)
    CustomHorizontalDivider()
}