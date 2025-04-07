package com.furkanmulayim.golden.presentation.tab_main.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.Typo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowSettingsBottomSheet(
    showBottomSheet: Boolean, onDismiss: () -> Unit
) {
    if (showBottomSheet) {
        ModalBottomSheet(
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false),
            onDismissRequest = onDismiss
        ) {
            Column(
                modifier = Modifier.padding(
                    start = AppSize.PaddingLarge,
                    end = AppSize.PaddingLarge,
                    bottom = AppSize.PaddingLarge
                )
            ) {
                Text(
                    text = stringResource(id = R.string.swap_header),
                    style = Typo.font_16_w500.copy(MaterialTheme.colorScheme.onSecondary)
                )
            }
        }
    }
}