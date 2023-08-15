package com.revakovskyi.domain.useCases

import com.revakovskyi.domain.authTextVerification.VerifyEmail
import com.revakovskyi.domain.authTextVerification.VerifyLogin
import com.revakovskyi.domain.authTextVerification.VerifyName
import com.revakovskyi.domain.authTextVerification.VerifyPassword
import com.revakovskyi.domain.models.InputTextType
import com.revakovskyi.domain.models.Status
import javax.inject.Inject

class TextValidationUseCase @Inject constructor() {

    operator fun invoke(inputText: String, inputTextType: InputTextType): Status {
        return when (inputTextType) {
            InputTextType.Login     ->  VerifyLogin().verify(login = inputText)
            InputTextType.Password  ->  VerifyPassword().verify(password = inputText)
            InputTextType.Email     ->  VerifyEmail().verify(email = inputText)
            InputTextType.Name      ->  VerifyName().verify(name = inputText)
        }
    }

}