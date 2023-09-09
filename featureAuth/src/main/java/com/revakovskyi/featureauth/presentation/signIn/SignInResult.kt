package com.revakovskyi.featureauth.presentation.signIn

import com.revakovskyi.featureauth.presentation.models.UserData

data class SignInResult(
    val userData: UserData?,
    val errorMessage: String?,
)
