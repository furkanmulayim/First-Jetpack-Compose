package com.furkanmulayim.golden.ui.investing_screen

import BackgroundImage
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.furkanmulayim.golden.core.component.CustomAppBar
import com.furkanmulayim.golden.ui.theme.AppSize

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
fun InvestingScreen(navController: NavController, invest: String) {
    Scaffold {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            BackgroundImage()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = AppSize.PaddingLarge)
            ) {
                CustomAppBar(
                    backTitle = invest
                )
            }
        }
    }
}


