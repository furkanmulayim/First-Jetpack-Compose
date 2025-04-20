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
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.Typo

@Composable
fun CustomSecondaryButton(
    text: String, iconRes: Int?, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = colorScheme.secondary),
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
                text = text, style = Typo.font_11_w800.copy(color = Color.White)
            )

            if (iconRes != null) {
                CustomSpacerWidth(6)

                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = text,
                    tint = Color.White,
                    modifier = Modifier.size(AppSize.ButtonSecondaryIcons)
                )
            }

        }
    }
}