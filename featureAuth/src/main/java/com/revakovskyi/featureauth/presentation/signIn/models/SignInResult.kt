package com.revakovskyi.featureauth.presentation.signIn.models

data class SignInResult(
    val userData: UserData?,
    val errorMessage: String?,
)
