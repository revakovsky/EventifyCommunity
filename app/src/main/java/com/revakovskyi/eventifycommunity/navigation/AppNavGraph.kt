package com.revakovskyi.eventifycommunity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.extensions.registerNewRoute
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.featureauth.navigation.AuthNavigationRoute
import com.revakovskyi.featureprofile.navigation.ProfileNavigationRoute
import com.revakovskyi.featuresplash.navigation.SplashNavigationRoute

@Composable
internal fun AppNavGraph(
    splashNavigationRoute: SplashNavigationRoute,
    authNavigationRoute: AuthNavigationRoute,
    profileNavigationRoute: ProfileNavigationRoute
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainRoutes.SPLASH_ROUT
    ) {

        registerNewRoute(
            navigationRoute = splashNavigationRoute,
            navHostController = navController
        )

        registerNewRoute(
            navigationRoute = authNavigationRoute,
            navHostController = navController
        )

        registerNewRoute(
            navigationRoute = profileNavigationRoute,
            navHostController = navController
        )

    }

}