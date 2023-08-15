package com.revakovskyi.featureauth.presentation.models

import com.revakovskyi.domain.models.InputTextType

internal enum class AuthInputTextType {
    Login, Password, Email, Name, Surname
}


internal fun AuthInputTextType.toInputText(): InputTextType {
    return when (this) {
        AuthInputTextType.Login     ->  InputTextType.Login
        AuthInputTextType.Password  ->  InputTextType.Password
        AuthInputTextType.Email     ->  InputTextType.Email
        else                        ->  InputTextType.Name
    }
}
