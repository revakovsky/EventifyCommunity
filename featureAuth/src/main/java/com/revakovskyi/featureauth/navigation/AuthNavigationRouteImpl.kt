package com.revakovskyi.featureauth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.revakovskyi.featureauth.presentation.AuthScreen
import com.revakovskyi.core.navigation.MainRoutes

class AuthNavigationRouteImpl : AuthNavigationRoute {

    override val firstsScreenRoute: String
        get() = Screens.AuthScreen.route

    override val navigationRouteName: String
        get() = MainRoutes.AUTH_ROUT


    override fun registerRoute(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController
    ) {
        navGraphBuilder.navigation(
            startDestination = firstsScreenRoute,
            route = navigationRouteName
        ) {
            composable(route = firstsScreenRoute) {
                AuthScreen(navController = navHostController)
            }
        }
    }

}