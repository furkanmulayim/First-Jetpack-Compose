package com.furkanmulayim.golden.presentation.tab_main.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.buttons.icon_button.CustomIconNoBackButton
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.CustomTypo

@Composable
fun TopBarWidget(
    today: String,
    meOnClick: () -> Unit = {},
    settingOnClick: () -> Unit = {},
) {
    val welcome = stringResource(id = R.string.welcome)
    Row(
        modifier = Modifier
            .padding(
                top = AppSize.PaddingXLarge,
                start = AppSize.PaddingLarge,
                end = AppSize.PaddingLarge
            )
            .fillMaxWidth()
            .height(AppSize.ButtonHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                CustomIconNoBackButton(
                    R.drawable.svg_burger_menu,
                    meOnClick,
                    AppSize.ButtonMediumIconsHeight
                )
                CustomSpacerWidth(8)
                Column {
                    Text(
                        text = welcome,
                        style = CustomTypo.text.labelSmall.copy(color = MaterialTheme.colorScheme.tertiary)
                    )
                    Text(
                        text = today,
                        style = CustomTypo.text.labelSmall.copy(color = MaterialTheme.colorScheme.tertiaryContainer)
                    )
                }
            }

        }
        CustomIconNoBackButton(
            R.drawable.svg_settings,
            settingOnClick,
            AppSize.ButtonMediumIconsHeight
        )
    }
}
