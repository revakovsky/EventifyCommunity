package com.revakovskyi.featureauth.presentation.signIn.models

internal sealed class SignInState {

    object Success : SignInState()
    class Error(val message: String?) : SignInState()
    object Default : SignInState()

}
