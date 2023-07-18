package com.revakovskyi.eventifycommunity.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.revakovskyi.core.presentation.ui.theme.AppShapes
import com.revakovskyi.core.presentation.ui.theme.AppTypography
import com.revakovskyi.core.presentation.ui.theme.Dimens
import com.revakovskyi.core.presentation.ui.theme.LocalDimens
import com.revakovskyi.core.presentation.ui.theme.darkBackground
import com.revakovskyi.core.presentation.ui.theme.darkError
import com.revakovskyi.core.presentation.ui.theme.darkErrorContainer
import com.revakovskyi.core.presentation.ui.theme.darkInverseOnSurface
import com.revakovskyi.core.presentation.ui.theme.darkInversePrimary
import com.revakovskyi.core.presentation.ui.theme.darkInverseSurface
import com.revakovskyi.core.presentation.ui.theme.darkOnBackground
import com.revakovskyi.core.presentation.ui.theme.darkOnError
import com.revakovskyi.core.presentation.ui.theme.darkOnErrorContainer
import com.revakovskyi.core.presentation.ui.theme.darkOnPrimary
import com.revakovskyi.core.presentation.ui.theme.darkOnPrimaryContainer
import com.revakovskyi.core.presentation.ui.theme.darkOnSecondary
import com.revakovskyi.core.presentation.ui.theme.darkOnSecondaryContainer
import com.revakovskyi.core.presentation.ui.theme.darkOnSurface
import com.revakovskyi.core.presentation.ui.theme.darkOnSurfaceVariant
import com.revakovskyi.core.presentation.ui.theme.darkOnTertiary
import com.revakovskyi.core.presentation.ui.theme.darkOnTertiaryContainer
import com.revakovskyi.core.presentation.ui.theme.darkOutline
import com.revakovskyi.core.presentation.ui.theme.darkOutlineVariant
import com.revakovskyi.core.presentation.ui.theme.darkPrimary
import com.revakovskyi.core.presentation.ui.theme.darkPrimaryContainer
import com.revakovskyi.core.presentation.ui.theme.darkScrim
import com.revakovskyi.core.presentation.ui.theme.darkSecondary
import com.revakovskyi.core.presentation.ui.theme.darkSecondaryContainer
import com.revakovskyi.core.presentation.ui.theme.darkSurface
import com.revakovskyi.core.presentation.ui.theme.darkSurfaceTint
import com.revakovskyi.core.presentation.ui.theme.darkSurfaceVariant
import com.revakovskyi.core.presentation.ui.theme.darkTertiary
import com.revakovskyi.core.presentation.ui.theme.darkTertiaryContainer
import com.revakovskyi.core.presentation.ui.theme.lightBackground
import com.revakovskyi.core.presentation.ui.theme.lightError
import com.revakovskyi.core.presentation.ui.theme.lightErrorContainer
import com.revakovskyi.core.presentation.ui.theme.lightInverseOnSurface
import com.revakovskyi.core.presentation.ui.theme.lightInversePrimary
import com.revakovskyi.core.presentation.ui.theme.lightInverseSurface
import com.revakovskyi.core.presentation.ui.theme.lightOnBackground
import com.revakovskyi.core.presentation.ui.theme.lightOnError
import com.revakovskyi.core.presentation.ui.theme.lightOnErrorContainer
import com.revakovskyi.core.presentation.ui.theme.lightOnPrimary
import com.revakovskyi.core.presentation.ui.theme.lightOnPrimaryContainer
import com.revakovskyi.core.presentation.ui.theme.lightOnSecondary
import com.revakovskyi.core.presentation.ui.theme.lightOnSecondaryContainer
import com.revakovskyi.core.presentation.ui.theme.lightOnSurface
import com.revakovskyi.core.presentation.ui.theme.lightOnSurfaceVariant
import com.revakovskyi.core.presentation.ui.theme.lightOnTertiary
import com.revakovskyi.core.presentation.ui.theme.lightOnTertiaryContainer
import com.revakovskyi.core.presentation.ui.theme.lightOutline
import com.revakovskyi.core.presentation.ui.theme.lightOutlineVariant
import com.revakovskyi.core.presentation.ui.theme.lightPrimary
import com.revakovskyi.core.presentation.ui.theme.lightPrimaryContainer
import com.revakovskyi.core.presentation.ui.theme.lightScrim
import com.revakovskyi.core.presentation.ui.theme.lightSecondary
import com.revakovskyi.core.presentation.ui.theme.lightSecondaryContainer
import com.revakovskyi.core.presentation.ui.theme.lightSurface
import com.revakovskyi.core.presentation.ui.theme.lightSurfaceTint
import com.revakovskyi.core.presentation.ui.theme.lightSurfaceVariant
import com.revakovskyi.core.presentation.ui.theme.lightTertiary
import com.revakovskyi.core.presentation.ui.theme.lightTertiaryContainer

private val LightColors = lightColorScheme(
    primary = lightPrimary,
    onPrimary = lightOnPrimary,
    primaryContainer = lightPrimaryContainer,
    onPrimaryContainer = lightOnPrimaryContainer,

    secondary = lightSecondary,
    onSecondary = lightOnSecondary,
    secondaryContainer = lightSecondaryContainer,
    onSecondaryContainer = lightOnSecondaryContainer,

    tertiary = lightTertiary,
    onTertiary = lightOnTertiary,
    tertiaryContainer = lightTertiaryContainer,
    onTertiaryContainer = lightOnTertiaryContainer,

    error = lightError,
    errorContainer = lightErrorContainer,
    onError = lightOnError,
    onErrorContainer = lightOnErrorContainer,

    background = lightBackground,
    onBackground = lightOnBackground,

    surface = lightSurface,
    onSurface = lightOnSurface,
    surfaceVariant = lightSurfaceVariant,
    onSurfaceVariant = lightOnSurfaceVariant,

    outline = lightOutline,
    inverseOnSurface = lightInverseOnSurface,
    inverseSurface = lightInverseSurface,
    inversePrimary = lightInversePrimary,
    surfaceTint = lightSurfaceTint,
    outlineVariant = lightOutlineVariant,
    scrim = lightScrim,
)


private val DarkColors = darkColorScheme(
    primary = darkPrimary,
    onPrimary = darkOnPrimary,
    primaryContainer = darkPrimaryContainer,
    onPrimaryContainer = darkOnPrimaryContainer,

    secondary = darkSecondary,
    onSecondary = darkOnSecondary,
    secondaryContainer = darkSecondaryContainer,
    onSecondaryContainer = darkOnSecondaryContainer,

    tertiary = darkTertiary,
    onTertiary = darkOnTertiary,
    tertiaryContainer = darkTertiaryContainer,
    onTertiaryContainer = darkOnTertiaryContainer,

    error = darkError,
    errorContainer = darkErrorContainer,
    onError = darkOnError,
    onErrorContainer = darkOnErrorContainer,

    background = darkBackground,
    onBackground = darkOnBackground,

    surface = darkSurface,
    onSurface = darkOnSurface,
    surfaceVariant = darkSurfaceVariant,
    onSurfaceVariant = darkOnSurfaceVariant,

    outline = darkOutline,
    inverseOnSurface = darkInverseOnSurface,
    inverseSurface = darkInverseSurface,
    inversePrimary = darkInversePrimary,
    surfaceTint = darkSurfaceTint,
    outlineVariant = darkOutlineVariant,
    scrim = darkScrim,
)

@Composable
fun EventifyCommunityTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors =
        if (!useDarkTheme) LightColors
        else DarkColors

    CompositionLocalProvider(
        LocalDimens provides Dimens()
    ) {
        MaterialTheme(
            colorScheme = colors,
            shapes = AppShapes,
            typography = AppTypography,
            content = content
        )
    }

}