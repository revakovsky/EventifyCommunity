package com.revakovskyi.core.extensions

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.composableWithAnimatedTransition(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    enterAndExitVertically: Boolean = false,
    content: @Composable (AnimatedContentScope, NavBackStackEntry) -> Unit,
) {

    composable(
        route = route,
        enterTransition = {
            if (enterAndExitVertically) enterFromBottomToTop()
            else enterFromRightToLeft()
        },
        exitTransition = { exitFromRightToLeft() },
        popEnterTransition = { popEnterFromLeftToRight() },
        popExitTransition = {
            if (enterAndExitVertically) exitFromTopToBottom()
            else popExitFromLeftToRight()
        },
        arguments = arguments
    ) {
        content(this, it)
    }

}
