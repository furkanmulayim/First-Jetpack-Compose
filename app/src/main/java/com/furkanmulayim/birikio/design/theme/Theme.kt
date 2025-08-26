package com.furkanmulayim.birikio.design.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
    primary = primary, surface = surface_light, // Page Back
    inverseSurface = surface_dark, primaryContainer = Color.White, // Container Back
    onPrimaryContainer = icon_button_foreground_light, // Container icon & text
    secondaryContainer = iconButtonDarkBackLight // DARK Container icon & text
)
private val DarkColorScheme = darkColorScheme(
    primary = primary,
    surface = surface_dark,
    inverseSurface = surface_light,
    primaryContainer = iconButtonBackDark,
    onPrimaryContainer = icon_button_foreground_dark, // Container icon & text
    secondaryContainer = iconButtonDarkBackDark // DARK Container icon & text
)


@Composable
fun BirikioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme, typography = Typography(), content = content
    )
}