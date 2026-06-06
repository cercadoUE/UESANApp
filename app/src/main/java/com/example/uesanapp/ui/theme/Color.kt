package com.example.uesanapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val WorldCupGreen = Color(0xFF0E7A3A)
val WorldCupGreenDark = Color(0xFF054D24)
val WorldCupGold = Color(0xFFFFC72C)
val WorldCupGoldDark = Color(0xFFC89312)
val WorldCupRed = Color(0xFFD62828)
val WorldCupBlue = Color(0xFF1D4ED8)
val WorldCupSurface = Color(0xFFF5F7F4)
val WorldCupSurfaceDark = Color(0xFF13261B)
val WorldCupOnSurface = Color(0xFF0F1A14)
val WorldCupOnSurfaceDark = Color(0xFFEAF1E7)

val WorldCupHeaderGradient: Brush
    get() = Brush.verticalGradient(
        colors = listOf(WorldCupGreenDark, WorldCupGreen)
    )

val WorldCupTrophyGradient: Brush
    get() = Brush.linearGradient(
        colors = listOf(WorldCupGold, WorldCupGoldDark)
    )
