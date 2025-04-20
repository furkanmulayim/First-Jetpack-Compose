package com.furkanmulayim.golden.presentation.theme

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

/**
onTertiary
onTertiaryContainer background onBackground surface onSurface surfaceVariant onSurfaceVariant
surfaceTint inverseSurface inverseOnSurface error onError errorContainer onErrorContainer
outline outlineVariant scrim surfaceBright surfaceContainer surfaceContainerHigh
surfaceContainerHighest surfaceContainerLow surfaceContainerLowest surfaceDim
 */

private val DarkColorScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = primaryLight,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    inverseSurface = soldDark,
    scrim = scrimDark,
    background = secondaryDark,
    onSecondaryContainer = onSecondaryContainerDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark
)

private val LightColorScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = primaryDark,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    inverseSurface = soldLight,
    scrim = scrimLight,
    background = Color.White,
    onSecondaryContainer = onSecondaryContainerLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight
)

@Composable
fun GoldenTheme(
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