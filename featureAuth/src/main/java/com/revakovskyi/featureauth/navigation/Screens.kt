package com.revakovskyi.featureauth.navigation

internal const val AUTH2_ARGUMENT_KEY = "text"

internal sealed class Screens(
    val route: String,
    val arguments: (String) -> String = { "" },
) {

    object SingInScreen : Screens("sing_in_screen")
    object SingUpScreen : Screens("sing_up_screen")

    object AuthScreen : Screens("auth_screen")
    object AuthScreen2 : Screens(
        "auth_screen2?$AUTH2_ARGUMENT_KEY={${AUTH2_ARGUMENT_KEY}}",
        arguments = { text -> "auth_screen2?$AUTH2_ARGUMENT_KEY=$text" }
    )

}