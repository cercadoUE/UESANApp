package com.example.uesanapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = WorldCupGold,
    onPrimary = Color(0xFF1B1B1B),
    primaryContainer = WorldCupGreen,
    onPrimaryContainer = WorldCupGold,
    secondary = WorldCupRed,
    onSecondary = Color.White,
    tertiary = WorldCupGold,
    background = WorldCupSurfaceDark,
    onBackground = WorldCupOnSurfaceDark,
    surface = WorldCupSurfaceDark,
    onSurface = WorldCupOnSurfaceDark,
    surfaceVariant = Color(0xFF1B2A1F),
    onSurfaceVariant = Color(0xFFC9D4C5)
)

private val LightColorScheme = lightColorScheme(
    primary = WorldCupGreen,
    onPrimary = Color.White,
    primaryContainer = WorldCupGreenDark,
    onPrimaryContainer = WorldCupGold,
    secondary = WorldCupGold,
    onSecondary = Color(0xFF1B1B1B),
    tertiary = WorldCupRed,
    onTertiary = Color.White,
    background = WorldCupSurface,
    onBackground = WorldCupOnSurface,
    surface = Color.White,
    onSurface = WorldCupOnSurface,
    surfaceVariant = WorldCupSurface,
    onSurfaceVariant = Color(0xFF3F4A42)
)

@Composable
fun UESANAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
