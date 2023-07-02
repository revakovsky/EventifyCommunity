package com.revakovskyi.featureauth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.featureauth.presentation.AuthScreen
import com.revakovskyi.featureauth.presentation.AuthScreen2
import javax.inject.Inject

internal class AuthNavigationRouteImpl @Inject constructor() : AuthNavigationRoute {

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

            composable(
                route = Screens.AuthScreen2.route,
                arguments = listOf(
                    navArgument(AUTH2_ARGUMENT_KEY) {
                        type = NavType.StringType
                        defaultValue = "Nothing was passed"
                    }
                )
            ) { navBackStackEntry ->
                AuthScreen2(
                    navController = navHostController,
                    text = navBackStackEntry.arguments?.getString(AUTH2_ARGUMENT_KEY)
                )
            }

        }
    }

}