package com.revakovskyi.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController

fun NavGraphBuilder.registerNewRoute(
    navigationRoute: NavigationRoute,
    navHostController: NavHostController
) {
    navigationRoute.registerRoute(
        navGraphBuilder = this,
        navHostController = navHostController
    )
}
