package com.furkanmulayim.birikio.ui

import BackgroundImage
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.furkanmulayim.birikio.ui.theme.AppSize

@Composable
fun BaseScreen(content: @Composable () -> Unit) {
    Scaffold { padding ->
        androidx.compose.foundation.layout.Box(
            modifier = Modifier.fillMaxSize()
        ) {
            BackgroundImage()

            Column(
                modifier = Modifier.run {
                    fillMaxSize().padding(horizontal = AppSize.PaddingLarge)
                }) {
                content()
            }
        }
    }
}