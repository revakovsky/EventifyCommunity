package com.revakovskyi.domain.useCases

import com.revakovskyi.domain.textVerification.InputTextType
import com.revakovskyi.domain.textVerification.Status
import com.revakovskyi.domain.textVerification.VerifyLogin
import com.revakovskyi.domain.textVerification.VerifyName
import com.revakovskyi.domain.textVerification.VerifyPassword
import javax.inject.Inject

class TextValidationUseCase @Inject constructor() {

    operator fun invoke(inputText: String, inputTextType: InputTextType): Status {
        return when (inputTextType) {
            InputTextType.Login -> VerifyLogin().verify(login = inputText)
            InputTextType.Password -> VerifyPassword().verify(password = inputText)
            InputTextType.Name -> VerifyName().verify(name = inputText)
        }
    }

}