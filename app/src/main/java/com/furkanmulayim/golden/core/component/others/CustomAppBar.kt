package com.furkanmulayim.golden.core.component.others


import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBackIosNew
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.buttons.icon_button.CustomIconButton
import com.furkanmulayim.golden.core.component.buttons.icon_button.CustomIconTextButton
import com.furkanmulayim.golden.core.extensions.debounced
import com.furkanmulayim.golden.ui.theme.AppSize

@Composable
fun CustomAppBar(
    backTitle: String,
    leadingClick: () -> Unit = {},
    isLeadingIconActive: Boolean = true,
) {
    val backDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    Row(
        modifier = Modifier
            .padding(top = AppSize.PaddingXLarge)
            .fillMaxWidth()
            .height(AppSize.ButtonHeight),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // TEXT ICON -> BACK BUTTON
        CustomIconTextButton(
            icon = Icons.Rounded.ArrowBackIosNew,
            text = backTitle,
            onClick = { backDispatcher?.onBackPressed() })

        if (isLeadingIconActive) {
            CustomIconButton(R.drawable.svg_card, leadingClick.debounced())
        }

    }


}
