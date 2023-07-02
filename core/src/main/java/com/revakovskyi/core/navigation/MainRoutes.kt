package com.revakovskyi.core.navigation

object MainRoutes {

    const val AUTH_ROUT = "AUTH_ROUT"
    const val SPLASH_ROUT = "SPLASH_ROUT"


    const val PROFILE_ROUT = "PROFILE_ROUT"
    var profileArgumentsText: String = ""
        private set
    fun goToProfileRoute(text: String = ""): String {
        profileArgumentsText = text
        return PROFILE_ROUT
    }

}