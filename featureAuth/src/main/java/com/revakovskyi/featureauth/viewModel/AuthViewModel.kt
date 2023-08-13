package com.revakovskyi.featureauth.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.revakovskyi.domain.useCases.TextValidationUseCase
import com.revakovskyi.featureauth.presentation.models.AuthInputTextType
import com.revakovskyi.featureauth.presentation.models.ValidationStatus
import com.revakovskyi.featureauth.presentation.models.toInputText
import com.revakovskyi.featureauth.presentation.models.toValidationStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class AuthViewModel @Inject constructor(
    private val textValidationUseCase: TextValidationUseCase,
) : ViewModel() {

    var loginValidationStatus by mutableStateOf(ValidationStatus.Neutral)
    var passwordValidationStatus by mutableStateOf(ValidationStatus.Neutral)
    var nameValidationStatus by mutableStateOf(ValidationStatus.Neutral)
    var surnameValidationStatus by mutableStateOf(ValidationStatus.Neutral)
    var doubleCheckPasswordValidationStatus by mutableStateOf(ValidationStatus.Neutral)

    fun verifyInputText(inputText: String, inputTextType: AuthInputTextType) {
        when (inputTextType) {
            AuthInputTextType.Login     ->  validateLogin(inputLogin = inputText)
            AuthInputTextType.Password  ->  validatePassword(inputPassword = inputText)
            AuthInputTextType.Name      ->  validateName(inputName = inputText)
            AuthInputTextType.Surname   ->  validateSurname(inputSurname = inputText)
        }
    }

    fun verifyDoubleCheckPassword(doubleCheckPassword: String, password: String) {
        doubleCheckPasswordValidationStatus = ValidationStatus.Neutral
        if (doubleCheckPassword.isNotEmpty()) {
            doubleCheckPasswordValidationStatus =
                if (doubleCheckPassword == password) ValidationStatus.Correct
                else ValidationStatus.Incorrect
        }
    }

    private fun validateLogin(inputLogin: String) {
        textValidationUseCase(inputLogin, AuthInputTextType.Login.toInputText()).also { status ->
            loginValidationStatus = status.toValidationStatus()
        }
    }

    private fun validatePassword(inputPassword: String) {
        textValidationUseCase(inputPassword, AuthInputTextType.Password.toInputText()).also { status ->
            passwordValidationStatus = status.toValidationStatus()
        }
    }

    private fun validateName(inputName: String) {
        nameValidationStatus = ValidationStatus.Neutral
        if (inputName.isNotEmpty()) {
            textValidationUseCase(inputName, AuthInputTextType.Name.toInputText()).also { status ->
                nameValidationStatus = status.toValidationStatus()
            }
        }
    }

    private fun validateSurname(inputSurname: String) {
        surnameValidationStatus = ValidationStatus.Neutral
        if (inputSurname.isNotEmpty()) {
            textValidationUseCase(inputSurname, AuthInputTextType.Name.toInputText()).also { status ->
                surnameValidationStatus = status.toValidationStatus()
            }
        }
    }

}