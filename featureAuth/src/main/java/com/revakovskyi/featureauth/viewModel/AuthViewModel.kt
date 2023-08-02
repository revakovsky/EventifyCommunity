package com.revakovskyi.featureauth.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.revakovskyi.domain.textVerification.InputTextType
import com.revakovskyi.domain.textVerification.Status
import com.revakovskyi.domain.useCases.TextValidationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val textValidationUseCase: TextValidationUseCase,
) : ViewModel() {

    var isLoginValid by mutableStateOf(true)
    var isLoginInvalid by mutableStateOf(false)

    fun verifyInputText(inputText: String) {
        isLoginInvalid = false
        textValidationUseCase(inputText, InputTextType.Login).also { validationStatus ->
            when (validationStatus) {
                Status.Correct -> {
                    isLoginValid = true
                    isLoginInvalid = false
                }

                Status.Incorrect -> {
                    isLoginValid = false
                    isLoginInvalid = true
                }

                Status.Neutral -> {
                    isLoginValid = false
                    isLoginInvalid = false
                }
            }
        }
    }

}