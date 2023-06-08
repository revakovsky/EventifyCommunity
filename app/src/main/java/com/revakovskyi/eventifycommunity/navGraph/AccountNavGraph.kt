package com.revakovskyi.eventifycommunity.navGraph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation

fun NavGraphBuilder.accountNavGraph(
    navController: NavController
) {

    navigation(
        startDestination = Screens.AccountScreen.route,
        route = Screens.ACCOUNT_ROUT
    ) {
        // add screens to this route
    }

}