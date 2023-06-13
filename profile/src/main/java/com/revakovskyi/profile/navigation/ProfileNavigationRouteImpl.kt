package com.revakovskyi.profile.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.profile.presentation.ProfileScreen

class ProfileNavigationRouteImpl : ProfileNavigationRoute {

    override val firstsScreenRoute: String
        get() = Screens.ProfileScreen.route

    override val navigationRouteName: String
        get() = MainRoutes.PROFILE_ROUT


    override fun registerRoute(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController
    ) {
        navGraphBuilder.navigation(
            startDestination = firstsScreenRoute,
            route = navigationRouteName
        ) {
            composable(route = firstsScreenRoute) {
                ProfileScreen(navController = navHostController)
            }
        }
    }

}