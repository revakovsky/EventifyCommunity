package com.revakovskyi.eventifycommunity.navigation

sealed class Screens(val route: String) {

    object SplashScreen : Screens("splash_screen")
    object AuthScreen : Screens("auth_screen")

}