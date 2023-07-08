package com.revakovskyi.eventifycommunity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.navigation.MainRoutes

@Composable
internal fun AppNavGraph(navigationRoutesProvider: NavigationRoutesProvider) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainRoutes.SplashScreenRoute.route
    ) {

        registerNewRoute(
            navigationRoute = navigationRoutesProvider.provideSplashNavigationRoute(),
            navHostController = navController
        )

        registerNewRoute(
            navigationRoute = navigationRoutesProvider.provideAuthNavigationRoute(),
            navHostController = navController
        )

        registerNewRoute(
            navigationRoute = navigationRoutesProvider.provideProfileNavigationRoute(),
            navHostController = navController
        )

    }

}