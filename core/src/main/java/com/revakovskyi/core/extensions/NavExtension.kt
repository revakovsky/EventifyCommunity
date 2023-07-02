package com.revakovskyi.core.extensions

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.revakovskyi.core.navigation.NavigationRoute

fun NavGraphBuilder.registerNewRoute(
    navigationRoute: NavigationRoute,
    navHostController: NavHostController
) {
    navigationRoute.registerRoute(
        navGraphBuilder = this,
        navHostController = navHostController
    )
}
