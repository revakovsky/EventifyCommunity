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

    var isLoginValid by mutableStateOf(true)
    var isLoginInvalid by mutableStateOf(false)
    var isPasswordValid by mutableStateOf(true)

    fun verifyInputText(inputText: String, inputTextType: AuthInputTextType) {
        when (inputTextType) {
            AuthInputTextType.Login -> validateLogin(inputText)
            AuthInputTextType.Password -> validatePassword(inputText)
            AuthInputTextType.Name -> Unit  // TODO: create validation method
        }
    }

    private fun validateLogin(inputText: String) {
        isLoginInvalid = false
        textValidationUseCase(
            inputText,
            AuthInputTextType.Login.toInputText()
        ).also { status ->

            when (status.toValidationStatus()) {
                ValidationStatus.Correct -> {
                    isLoginValid = true
                    isLoginInvalid = false
                }

                ValidationStatus.Incorrect -> {
                    isLoginValid = false
                    isLoginInvalid = true
                }

                ValidationStatus.Neutral -> {
                    isLoginValid = false
                    isLoginInvalid = false
                }
            }
        }
    }

    private fun validatePassword(inputText: String) {
        textValidationUseCase(
            inputText,
            AuthInputTextType.Password.toInputText()
        ).also { status ->
            isPasswordValid = when (status.toValidationStatus()) {
                ValidationStatus.Correct -> true
                else -> false
            }
        }
    }

}