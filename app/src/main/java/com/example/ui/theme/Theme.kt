package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val LightColorScheme = lightColorScheme(
    primary = RoyalIndigo,
    onPrimary = Color.White,
    primaryContainer = SoftIndigoContainer,
    onPrimaryContainer = OnSoftIndigo,
    secondary = SaffronOrange,
    onSecondary = Color.White,
    secondaryContainer = SoftSaffronContainer,
    onSecondaryContainer = OnSoftSaffron,
    tertiary = EmeraldTeal,
    onTertiary = Color.White,
    tertiaryContainer = SoftTealContainer,
    onTertiaryContainer = OnSoftTeal,
    background = WarmIvoryBackground,
    onBackground = InkCharcoal,
    surface = WarmSurface,
    onSurface = InkCharcoal,
    surfaceVariant = WarmSurfaceVariant,
    onSurfaceVariant = MutedSlate,
    outline = SoftBorder,
    outlineVariant = SoftBorder,
    error = QuizWrong,
    onError = Color.White,
    errorContainer = QuizWrongBg,
    onErrorContainer = Color(0xFF7F1D1D)
)

private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = Color(0xFFE6E4FF),
    secondary = DarkSecondary,
    onSecondary = Color(0xFF451600),
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = Color(0xFFFFDEC9),
    tertiary = DarkTertiary,
    onTertiary = Color(0xFF003832),
    tertiaryContainer = DarkTertiaryContainer,
    onTertiaryContainer = Color(0xFFCCFBF1),
    background = DarkBackground,
    onBackground = DarkTextPrimary,
    surface = DarkSurface,
    onSurface = DarkTextPrimary,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkTextMuted,
    outline = DarkBorder,
    outlineVariant = DarkBorder,
    error = Color(0xFFFCA5A5),
    onError = Color(0xFF7F1D1D),
    errorContainer = Color(0xFF450A0A),
    onErrorContainer = Color(0xFFFECACA)
)

val VidyaShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(22.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

@Composable
fun VidyaPathTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = VidyaTypography,
        shapes = VidyaShapes,
        content = content
    )
}
