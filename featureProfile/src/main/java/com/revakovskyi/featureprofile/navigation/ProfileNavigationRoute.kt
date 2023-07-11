package com.revakovskyi.featureprofile.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.core.navigation.NavigationRoute
import com.revakovskyi.featureprofile.presentation.ProfileScreen
import javax.inject.Inject

interface ProfileNavigationRoute : NavigationRoute


internal class ProfileNavigationRouteImpl @Inject constructor() : ProfileNavigationRoute {

    override val firstsScreenRoute: String
        get() = Screens.ProfileScreen.route

    override val navigationRouteName: String
        get() = MainRoutes.ProfileScreenRoute.route

    override fun registerRoute(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController
    ) {
        navGraphBuilder.navigation(
            startDestination = firstsScreenRoute,
            route = navigationRouteName
        ) {

            composable(route = firstsScreenRoute) {
                ProfileScreen(
                    navController = navHostController,
                    text = MainRoutes.provideArgumentsForTheProfileRoute,
                )
            }

        }
    }

}