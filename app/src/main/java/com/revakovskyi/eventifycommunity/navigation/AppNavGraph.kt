package com.revakovskyi.eventifycommunity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.core.navigation.registerNewRoute

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainRoutes.SPLASH_ROUT
    ) {
        registerNewRoute(
            navigationRoute = DependencyProvider.splashNavigationRoute(),
            navHostController = navController
        )

        registerNewRoute(
            navigationRoute = DependencyProvider.authNavigationRoute(),
            navHostController = navController
        )

        registerNewRoute(
            navigationRoute = DependencyProvider.profileNavigationRoute(),
            navHostController = navController
        )

    }

}