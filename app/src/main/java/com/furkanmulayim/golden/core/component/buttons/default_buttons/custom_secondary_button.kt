package com.furkanmulayim.golden.core.component.buttons.default_buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.golden.core.component.CustomSpacerWidth
import com.furkanmulayim.golden.ui.theme.AppSize
import com.furkanmulayim.golden.ui.theme.CustomTypo
import com.furkanmulayim.golden.ui.theme.white700

@Composable
fun CustomSecondaryButton(
    text: String, iconRes: Int, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
        shape = RoundedCornerShape(AppSize.RadiusButtons),
        modifier = modifier.height(AppSize.ButtonHeight),
        contentPadding = PaddingValues(
            horizontal = AppSize.PaddingSmall, vertical = AppSize.PaddingXSmall
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = text, style = CustomTypo.text.labelSmall.copy(color = white700)
            )
            CustomSpacerWidth(6)

            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = text,
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.size(AppSize.ButtonIconsHeight)
            )
        }
    }
}