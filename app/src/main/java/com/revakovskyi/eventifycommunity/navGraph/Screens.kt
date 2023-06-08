package com.revakovskyi.eventifycommunity.navGraph

sealed class Screens(val route: String) {

    object SplashScreen : Screens("splash_screen")
    object AuthScreen : Screens("auth_screen")
    object ProfileScreen : Screens("profile_screen")
    object CreateEventScreen : Screens("create_event_screen")
    object FavouriteScreen : Screens("favourite_screen")
    object AccountScreen : Screens("account_screen")

    companion object {
        const val AUTH_ROUT = "AUTH_ROUT"
        const val PROFILE_ROUT = "PROFILE_ROUT"
        const val CREATE_EVENT_ROUT = "CREATE_EVENT_ROUT"
        const val ACCOUNT_ROUT = "ACCOUNT_ROUT"
    }

}