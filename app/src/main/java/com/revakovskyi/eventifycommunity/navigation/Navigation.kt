package com.revakovskyi.eventifycommunity.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.eventifycommunity.presentation.AuthScreen
import com.revakovskyi.eventifycommunity.presentation.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.SplashScreen.route) {
        composable(route = Screens.SplashScreen.route) { SplashScreen(navController = navController) }
        composable(route = Screens.AuthScreen.route) { AuthScreen(navController = navController) }
    }
}