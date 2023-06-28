package com.revakovskyi.featureauth.navigation

internal sealed class Screens(val route: String) {

    object AuthScreen : Screens("auth_screen")

}