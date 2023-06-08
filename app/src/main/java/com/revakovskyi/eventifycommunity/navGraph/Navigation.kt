package com.revakovskyi.eventifycommunity.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.eventifycommunity.presentation.SplashScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.SplashScreen.route) { SplashScreen(navController = navController) }
        composable(route = Screens.FavouriteScreen.route) { /*add favourite screen*/ }

        authNavGraph(navController)
        profileNavGraph(navController)
        createEventNavGraph(navController)
        accountNavGraph(navController)
    }

}