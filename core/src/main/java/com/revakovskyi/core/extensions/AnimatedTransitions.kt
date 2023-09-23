package com.revakovskyi.core.extensions

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.navigation.NavBackStackEntry
import com.revakovskyi.core.utils.Constants.DEFAULT_ANIMATION_DURATION
import com.revakovskyi.core.utils.Constants.FADE_DURATION

fun AnimatedContentTransitionScope<NavBackStackEntry>.enterFromRightToLeft() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Start,
        animationSpec = tween(
            durationMillis = DEFAULT_ANIMATION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeIn(
        animationSpec = tween(
            durationMillis = FADE_DURATION,
            easing = FastOutSlowInEasing
        )
    )


fun AnimatedContentTransitionScope<NavBackStackEntry>.exitFromRightToLeft() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Start,
        animationSpec = tween(
            durationMillis = DEFAULT_ANIMATION_DURATION,
            easing = FastOutLinearInEasing
        ),
    ) + fadeOut(
        animationSpec = tween(
            durationMillis = FADE_DURATION,
            easing = FastOutLinearInEasing
        )
    )


fun AnimatedContentTransitionScope<NavBackStackEntry>.popEnterFromLeftToRight() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.End,
        animationSpec = tween(
            durationMillis = DEFAULT_ANIMATION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeIn(
        animationSpec = tween(
            durationMillis = FADE_DURATION,
            easing = FastOutSlowInEasing
        )
    )


fun AnimatedContentTransitionScope<NavBackStackEntry>.popExitFromLeftToRight() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.End,
        animationSpec = tween(
            durationMillis = DEFAULT_ANIMATION_DURATION,
            easing = FastOutLinearInEasing
        ),
    ) + fadeOut(
        animationSpec = tween(
            durationMillis = FADE_DURATION,
            easing = FastOutLinearInEasing
        )
    )


fun AnimatedContentTransitionScope<NavBackStackEntry>.enterFromBottomToTop() =
    slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Up,
        animationSpec = tween(
            durationMillis = DEFAULT_ANIMATION_DURATION,
            easing = FastOutSlowInEasing
        )
    ) + fadeIn(
        animationSpec = tween(
            durationMillis = FADE_DURATION,
            easing = FastOutSlowInEasing
        )
    )


fun AnimatedContentTransitionScope<NavBackStackEntry>.exitFromTopToBottom() =
    slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Companion.Down,
        animationSpec = tween(
            durationMillis = DEFAULT_ANIMATION_DURATION,
            easing = FastOutLinearInEasing
        ),
    ) + fadeOut(
        animationSpec = tween(
            durationMillis = FADE_DURATION,
            easing = FastOutLinearInEasing
        )
    )
