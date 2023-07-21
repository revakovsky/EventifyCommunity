package com.revakovskyi.featureauth.navigation

import com.revakovskyi.featureauth.navigation.Screens.PhoneVerificationScreen.route

internal const val AUTH2_ARGUMENT_KEY = "text"
internal const val PHONE_NUMBER_ARGUMENT_KEY = "phone_number"

internal sealed class Screens(
    val route: String,
    val arguments: (String) -> String = { "" },
) {

    object SingInScreen : Screens("sing_in_screen")
    object SingUpScreen : Screens("sing_up_screen")
    object PhoneVerificationScreen : Screens(
        route = "phone_verification_screen/{$PHONE_NUMBER_ARGUMENT_KEY}",
        arguments = { phoneNumber ->
            route.replace(
                oldValue = "{$PHONE_NUMBER_ARGUMENT_KEY}",
                newValue = phoneNumber
            )
        }
    )

    object AuthScreen : Screens("auth_screen")
    object AuthScreen2 : Screens(
        "auth_screen2?$AUTH2_ARGUMENT_KEY={${AUTH2_ARGUMENT_KEY}}",
        arguments = { text -> "auth_screen2?$AUTH2_ARGUMENT_KEY=$text" }
    )

}