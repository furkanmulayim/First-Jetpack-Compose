package com.furkanmulayim.golden.core.component.buttons.icon_button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.CustomSpacerWidth
import com.furkanmulayim.golden.ui.theme.AppSize
import com.furkanmulayim.golden.ui.theme.CustomTypo
import com.furkanmulayim.golden.ui.theme.white400
import com.furkanmulayim.golden.ui.theme.white700

@Composable
fun CustomIconTextFlatButton(icon: Int, onClick: () -> Unit) {

    val welcome = stringResource(id = R.string.welcome)
    val day = stringResource(id = R.string.day)
    /** toDo günün tarihi alınacak */
    Box(
        Modifier
            .clip(RoundedCornerShape(AppSize.RadiusMedium))
            .clickable { onClick() }
            .padding(AppSize.PaddingSmall)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painterResource(icon),
                tint = MaterialTheme.colorScheme.onSecondaryContainer,
                contentDescription = "menu",
                modifier = Modifier.size(AppSize.ButtonIconsHeight),
            )
            CustomSpacerWidth(8)
            Column {
                Text(
                    text = welcome, style = CustomTypo.text.labelSmall.copy(color = white400)
                )
                Text(
                    text = day, style = CustomTypo.text.labelSmall.copy(color = white700)
                )
            }
        }
    }
}