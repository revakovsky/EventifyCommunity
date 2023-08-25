package com.revakovskyi.featureauth.navigation

import com.revakovskyi.featureauth.navigation.Screens.EmailAndPhoneVerificationScreen.route

internal const val VERIFICATION_ARGUMENT_KEY = "email_or_phone_number"

internal sealed class Screens(
    val route: String,
    val arguments: (String) -> String = { "" },
) {

    object SingInScreen : Screens("sing_in_screen")
    object ForgotPasswordScreen : Screens("forgot_password_screen")
    object SingUpScreen : Screens("sing_up_screen")
    object EmailAndPhoneVerificationScreen : Screens(
        route = "verification_screen/{$VERIFICATION_ARGUMENT_KEY}",
        arguments = { phoneNumber ->
            route.replace(
                oldValue = "{$VERIFICATION_ARGUMENT_KEY}",
                newValue = phoneNumber
            )
        }
    )

}