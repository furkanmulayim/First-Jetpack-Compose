package com.furkanmulayim.birikio.feature

import BackgroundImage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.furkanmulayim.birikio.design.theme.BirikioTheme
import com.furkanmulayim.birikio.feature.screen_onboarding.data.local.OnboardingDataStore
import com.furkanmulayim.birikio.navigation.AppNavigation
import com.furkanmulayim.birikio.navigation.AppScreens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val context = LocalContext.current
            val navController = rememberNavController()
            var startDestination by remember { mutableStateOf<String?>(null) }

            LaunchedEffect(Unit) {
                OnboardingDataStore.readOnboardingState(context).collect { shown ->
                    startDestination = if (shown) {
                        AppScreens.HomeScreen.route
                    } else {
                        AppScreens.OnboardingScreen.route
                    }
                }
            }

            BirikioTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BackgroundImage()
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        if (startDestination != null) {
                            AppNavigation(
                                navController = navController,
                                startDestination = startDestination!!
                            )
                        }
                    }
                }
            }
        }
    }
}