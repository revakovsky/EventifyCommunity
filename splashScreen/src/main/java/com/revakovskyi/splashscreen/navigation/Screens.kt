package com.revakovskyi.splashscreen.navigation

internal sealed class Screens(val route: String) {

    object SplashScreen : Screens("splash_screen")

}