package com.revakovskyi.featuresplash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.core.navigation.NavigationRoute
import com.revakovskyi.featuresplash.presentation.SplashScreen
import javax.inject.Inject

interface SplashNavigationRoute : NavigationRoute


internal class SplashNavigationRouteImpl @Inject constructor() : SplashNavigationRoute {

    override val firstsScreenRoute: String
        get() = Screens.SplashScreen.route

    override val navigationRouteName: String
        get() = MainRoutes.SplashScreenRoute.route


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