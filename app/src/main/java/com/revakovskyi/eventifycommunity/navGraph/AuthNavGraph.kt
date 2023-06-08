package com.revakovskyi.eventifycommunity.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.revakovskyi.eventifycommunity.presentation.AuthScreen

fun NavGraphBuilder.authNavGraph(
    navController: NavController
) {

    navigation(
        startDestination = Screens.AuthScreen.route,
        route = Screens.AUTH_ROUT
    ) {
        composable(route = Screens.AuthScreen.route) { AuthScreen(navController = navController) }
        // add other screens to this route
    }

}