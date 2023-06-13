package com.revakovskyi.splashscreen.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.splashscreen.presentation.SplashScreen

class SplashNavigationRouteImpl : SplashNavigationRoute {

    override val firstsScreenRoute: String
        get() = Screens.SplashScreen.route

    override val navigationRouteName: String
        get() = MainRoutes.SPLASH_ROUT


    override fun registerRoute(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController
    ) {
        navGraphBuilder.navigation(
            startDestination = firstsScreenRoute,
            route = navigationRouteName
        ) {
            composable(route = firstsScreenRoute) {
                SplashScreen(navController = navHostController)
            }
        }
    }

}