package com.revakovskyi.core.extensions

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInFromBottomToTop() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Up,
        animationSpec = tween(700)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInFromRightToLeft() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
        animationSpec = tween(700)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInFromLeftToRight() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
        animationSpec = tween(700)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutFromRightToLeft() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
        animationSpec = tween(700)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutFromLeftToRight() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
        animationSpec = tween(700)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutFromTopToBottom() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Down,
        animationSpec = tween(700)
    )
