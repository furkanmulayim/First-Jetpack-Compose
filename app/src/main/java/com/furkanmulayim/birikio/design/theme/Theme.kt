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
    primary = Color(0xFF007AFF),//
    surface = Color(0xFFF2F2F7), // Page Back
    inverseSurface = Color(0xFF111111), // Page icon & text
    surfaceVariant = Color(0xFFF5F5FF), // Exchange Back, App Bar
    surfaceBright = Color.White,
    primaryContainer = Color.White, // All Container Back
    onPrimaryContainer = Color(0xFF959598), // Container icon & text
    secondaryContainer = Color(0xFFE5E5E9), // DARK Container icon & text
    secondary = Color(0xFF2C2B2B),
    outline = Color(0x25494949)


)
private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF007AFF),
    surface = Color(0xFF111111),
    inverseSurface = Color(0xFFF2F2F7),
    surfaceVariant = Color(0xFF1A1919),
    surfaceBright = Color(0xFF252424),
    primaryContainer = Color(0xFF212121),
    onPrimaryContainer = Color(0xFF959598),
    secondaryContainer = Color(0xFF3B3B3B),
    secondary = Color(0xFF989898),
    outline = Color(0x25494949)

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