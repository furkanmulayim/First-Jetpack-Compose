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
inversePrimary onTertiary
onTertiaryContainer background onBackground surface onSurface surfaceVariant onSurfaceVariant
surfaceTint inverseSurface inverseOnSurface error onError errorContainer onErrorContainer
outline outlineVariant scrim surfaceBright surfaceContainer surfaceContainerHigh
surfaceContainerHighest surfaceContainerLow surfaceContainerLowest surfaceDim
 */

private val DarkColorScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = Color.White,
    onPrimaryContainer = linerDark,
    inversePrimary = buyDark,
    inverseSurface = soldDark,
    primaryContainer = Color.White,
    secondary = secondaryDark,
    onSecondary = Color.White,
    tertiary = tertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    surface = surfaceDark,
    onSecondaryContainer = onSecondaryContainerDark,
)

private val LightColorScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = Color.White,
    onPrimaryContainer = linerLight,
    inversePrimary = buyLight,
    inverseSurface = soldLight,
    primaryContainer = primaryLight,
    secondary = secondaryLight,
    onSecondary = Color.White,
    tertiary = tertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    surface = surfaceLight,
    onSecondaryContainer = tertiaryLight,


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