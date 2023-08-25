package com.revakovskyi.core.extensions

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.navigation.NavBackStackEntry
import com.revakovskyi.core.util.Constants.DEFAULT_ANIMATION_DURATION

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInFromBottomToTop() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Up,
        animationSpec = tween(DEFAULT_ANIMATION_DURATION)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInFromRightToLeft() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
        animationSpec = tween(DEFAULT_ANIMATION_DURATION)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideInFromLeftToRight() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
        animationSpec = tween(DEFAULT_ANIMATION_DURATION)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutFromRightToLeft() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Left,
        animationSpec = tween(DEFAULT_ANIMATION_DURATION)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutFromLeftToRight() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Right,
        animationSpec = tween(DEFAULT_ANIMATION_DURATION)
    )

fun AnimatedContentTransitionScope<NavBackStackEntry>.slideOutFromTopToBottom() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Down,
        animationSpec = tween(DEFAULT_ANIMATION_DURATION)
    )
