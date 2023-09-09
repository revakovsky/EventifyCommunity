package com.revakovskyi.featureauth.presentation.signIn

internal data class SignInState(
    val isSuccessful: Boolean = false,
    val errorMessage: String? = null,
)
