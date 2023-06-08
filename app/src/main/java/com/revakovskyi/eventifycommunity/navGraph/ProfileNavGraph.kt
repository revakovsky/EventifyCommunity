package com.revakovskyi.eventifycommunity.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation

fun NavGraphBuilder.profileNavGraph(
    navController: NavController
) {

    navigation(
        startDestination = Screens.ProfileScreen.route,
        route = Screens.PROFILE_ROUT
    ) {
        // add screens to this route
    }

}