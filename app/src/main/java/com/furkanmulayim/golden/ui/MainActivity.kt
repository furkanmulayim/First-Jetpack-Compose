package com.furkanmulayim.golden.ui

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
import com.furkanmulayim.golden.navigation.AppNavigation
import com.furkanmulayim.golden.ui.theme.GoldenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            GoldenTheme {
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