package com.furkanmulayim.golden.core.component.others

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.buttons.icon_button.CustomIconButton
import com.furkanmulayim.golden.core.extensions.debounceClickable
import com.furkanmulayim.golden.presentation.theme.AppSize

val LocalAppNavController = compositionLocalOf<NavController> {
    error("No NavController provided")
}

@Composable
fun CustomTopBarWidget(
    leadingClick: () -> Unit = {}
) {
    val navController = LocalAppNavController.current

    Row(
        modifier = Modifier
            .padding(top = AppSize.PaddingXLarge)
            .fillMaxWidth()
            .height(AppSize.ButtonHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(AppSize.RadiusMedium))
                .debounceClickable(
                    600,
                    onClick = {
                        navController.popBackStack()
                    },
                )

                .padding(vertical = AppSize.PaddingSmall, horizontal = AppSize.PaddingMedium),
        ) {
            Icon(
                painterResource(R.drawable.svg_arrow_left),
                tint = colorScheme.primaryContainer,
                contentDescription = "menu",
                modifier = Modifier.size(AppSize.ButtonIconsHeight),
            )
            CustomSpacerWidth(16)
            Text("BACKING")
        }
        //  ICON -> WALLET
        CustomIconButton(R.drawable.svg_wallet, leadingClick)
    }
}
