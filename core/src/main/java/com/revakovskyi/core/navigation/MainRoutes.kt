package com.revakovskyi.core.navigation

sealed class MainRoutes(
    val route: String,
    val stringArguments: (String) -> String = { "" },
    val shouldSignOut: (Boolean) -> String = { "" },
) {

    object SplashScreenRoute : MainRoutes(SPLASH_ROUT)

    object AuthScreenRoute : MainRoutes(
        AUTH_ROUT,
        shouldSignOut = { value ->
            provideArgumentsForTheAuthRoute = value
            AUTH_ROUT
        }
    )

    object ProfileScreenRoute : MainRoutes(
        PROFILE_ROUT,
        stringArguments = { passedText ->
            provideArgumentsForTheProfileRoute = passedText
            PROFILE_ROUT
        }
    )


    companion object {
        private const val SPLASH_ROUT = "SPLASH_ROUT"
        private const val AUTH_ROUT = "AUTH_ROUT"
        var provideArgumentsForTheAuthRoute: Boolean = false
            internal set

        private const val PROFILE_ROUT = "PROFILE_ROUT"
        var provideArgumentsForTheProfileRoute: String = ""
            internal set
    }

}