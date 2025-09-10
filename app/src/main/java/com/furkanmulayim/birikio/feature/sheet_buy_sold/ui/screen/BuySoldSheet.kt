package com.furkanmulayim.birikio.feature.sheet_buy_sold.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.furkanmulayim.birikio.design.component.page.CustomScaffold
import com.furkanmulayim.birikio.design.theme.Appsize

@Composable
fun BuySoldSheet(
    onClose: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surfaceVariant)
            .padding(top = Appsize.zero)
    ) {
        CustomScaffold { }
    }
}