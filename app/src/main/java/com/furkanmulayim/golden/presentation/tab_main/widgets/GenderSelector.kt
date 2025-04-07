package com.furkanmulayim.golden.presentation.tab_main.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.buttons.icon_button.CustomIconButton
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.Typo
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderSelector(
    selectedIndex: Int, onSelectionChanged: (Int) -> Unit
) {

    var showBottomSheet by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    ShowSettingsBottomSheet(
        showBottomSheet = showBottomSheet, onDismiss = { showBottomSheet = false })

    val selectedColor = MaterialTheme.colorScheme.onSecondary
    val unSelectedColor = MaterialTheme.colorScheme.secondary

    val options = listOf("YATIRIMLARIM", "CÜZDANIM")

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = AppSize.PaddingXLarge,
                start = AppSize.PaddingLarge,
                end = AppSize.PaddingLarge
            )
            .height(AppSize.ButtonHeight), verticalAlignment = Alignment.CenterVertically
    ) {
        // SOLDAKİ MENÜ ICON
        CustomIconButton(
            icon = R.drawable.svg_burger_menu, onClick = {})

        // ORTADAKİ TEXT + INDICATOR
        Box(
            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = if (selectedIndex == 0) options[0] else options[1],
                    style = Typo.font_16_w500.copy(selectedColor)
                )

                Row(
                    modifier = Modifier.padding(top = AppSize.PaddingXSmall),
                    horizontalArrangement = Arrangement.spacedBy(AppSize.PaddingSmall),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    (0..1).forEach { index ->
                        Box(
                            modifier = Modifier
                                .height(AppSize.two_dp)
                                .width(AppSize.ItemMaxImage)
                                .clip(RoundedCornerShape(AppSize.ButtonHeight))
                                .background(
                                    if (index == selectedIndex) selectedColor
                                    else unSelectedColor
                                )
                                .clickable { onSelectionChanged(index) })
                    }
                }
            }
        }

        // SAĞDAKİ SETTINGS ICON
        CustomIconButton(
            icon = R.drawable.svg_swap, onClick = {
                coroutineScope.launch {
                    showBottomSheet = true
                }
            })
    }
}
