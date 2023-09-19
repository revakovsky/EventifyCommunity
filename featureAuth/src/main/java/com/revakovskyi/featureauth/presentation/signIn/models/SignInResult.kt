package com.revakovskyi.featureauth.presentation.signIn.models

internal data class SignInResult(
    val userData: UserData?,
    val errorMessage: String?,
)
