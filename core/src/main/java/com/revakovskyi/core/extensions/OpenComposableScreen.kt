package com.revakovskyi.core.extensions

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.openAnimatedComposable(
    route: String,
    enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = { slideInFromRightToLeft() },
    exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = { slideOutFromRightToLeft() },
    popEnterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition = { slideInFromLeftToRight() },
    popExitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition = { slideOutFromLeftToRight() },
    arguments: List<NamedNavArgument> = emptyList(),
    content: @Composable (AnimatedContentScope, NavBackStackEntry) -> Unit,
) {
    composable(
        route = route,
        enterTransition = enterTransition,
        exitTransition = exitTransition,
        popEnterTransition = popEnterTransition,
        popExitTransition = popExitTransition,
        arguments = arguments
    ) {
        content(this, it)
    }
}
