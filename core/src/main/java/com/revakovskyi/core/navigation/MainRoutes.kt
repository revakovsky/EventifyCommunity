package com.revakovskyi.core.navigation

sealed class MainRoutes(
    val route: String,
    val arguments: (String) -> String = { "" }
) {

    object SplashScreenRoute : MainRoutes(SPLASH_ROUT)

    object AuthScreenRoute : MainRoutes(AUTH_ROUT)

    object ProfileScreenRoute : MainRoutes(
        PROFILE_ROUT,
        arguments = { passedText ->
            provideArgumentsForTheProfileRoute = passedText
            PROFILE_ROUT
        }
    )


    companion object {
        private const val SPLASH_ROUT = "SPLASH_ROUT"
        private const val AUTH_ROUT = "AUTH_ROUT"

        private const val PROFILE_ROUT = "PROFILE_ROUT"
        var provideArgumentsForTheProfileRoute: String = ""
            internal set
    }

}