package com.revakovskyi.featureprofile.navigation

internal sealed class Screens(val route: String) {

    object ProfileScreen : Screens("profile_screen")

}