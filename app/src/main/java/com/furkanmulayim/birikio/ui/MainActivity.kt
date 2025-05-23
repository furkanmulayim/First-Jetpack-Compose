package com.furkanmulayim.birikio.ui

import BackgroundImage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.furkanmulayim.birikio.nav.AppNavigation
import com.furkanmulayim.birikio.ui.theme.BirikioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            BirikioTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BackgroundImage()
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        AppNavigation(navController = navController)
                    }
                }
            }
        }
    }
}