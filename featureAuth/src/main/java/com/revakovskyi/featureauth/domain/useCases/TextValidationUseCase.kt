package com.revakovskyi.featureauth.domain.useCases

import com.revakovskyi.featureauth.domain.authTextVerification.VerifyEmail
import com.revakovskyi.featureauth.domain.authTextVerification.VerifyLogin
import com.revakovskyi.featureauth.domain.authTextVerification.VerifyName
import com.revakovskyi.featureauth.domain.authTextVerification.VerifyPassword
import com.revakovskyi.featureauth.domain.models.InputTextType
import com.revakovskyi.featureauth.domain.models.Status
import javax.inject.Inject

internal class TextValidationUseCase @Inject constructor() {

    operator fun invoke(inputText: String, inputTextType: InputTextType): Status {
        return when (inputTextType) {
            InputTextType.Login     ->  VerifyLogin.verify(login = inputText)
            InputTextType.Password  ->  VerifyPassword.verify(password = inputText)
            InputTextType.Email     ->  VerifyEmail.verify(email = inputText)
            InputTextType.Name      ->  VerifyName.verify(name = inputText)
        }
    }

}