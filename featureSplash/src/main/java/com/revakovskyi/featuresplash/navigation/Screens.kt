package com.revakovskyi.featuresplash.navigation

internal sealed class Screens(val route: String) {

    object SplashScreen : Screens("splash_screen")

}