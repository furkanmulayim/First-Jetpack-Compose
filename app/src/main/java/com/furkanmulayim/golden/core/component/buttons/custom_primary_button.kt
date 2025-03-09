package com.furkanmulayim.golden.core.component.buttons

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.golden.core.component.CustomSpacerWidth
import com.furkanmulayim.golden.core.extensions.debounced
import com.furkanmulayim.golden.ui.theme.AppSize
import com.furkanmulayim.golden.ui.theme.CustomTypo

@Composable
fun CustomPrimaryButton(
    text: String, iconRes: Int, onClick: () -> Unit, modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick.debounced(),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(AppSize.RadiusMedium),
        modifier = modifier
            .height(AppSize.ButtonHeight)

            .background(
                MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(AppSize.RadiusMedium)
            ),
        contentPadding = PaddingValues(
            horizontal = AppSize.PaddingSmall, vertical = AppSize.PaddingXSmall
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = text,
                tint = MaterialTheme.colorScheme.onSecondary,
                modifier = Modifier.size(AppSize.ButtonSmallHeight)
            )
            CustomSpacerWidth(8)
            Text(
                text = text, style = CustomTypo.text.bodySmall
            )
        }
    }
}