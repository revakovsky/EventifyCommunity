package com.revakovskyi.eventifycommunity.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation

fun NavGraphBuilder.createEventNavGraph(
    navController: NavController
) {

    navigation(
        startDestination = Screens.CreateEventScreen.route,
        route = Screens.CREATE_EVENT_ROUT
    ) {
        // add screens to this route
    }

}