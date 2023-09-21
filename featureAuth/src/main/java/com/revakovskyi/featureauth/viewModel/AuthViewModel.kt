package com.revakovskyi.featureauth.viewModel

import android.app.Activity
import androidx.activity.compose.ManagedActivityResultLauncher
import androidx.activity.result.ActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.revakovskyi.featureauth.domain.useCases.TextValidationUseCase
import com.revakovskyi.featureauth.presentation.models.AuthInputTextType
import com.revakovskyi.featureauth.presentation.models.ValidationStatus
import com.revakovskyi.featureauth.presentation.models.toInputText
import com.revakovskyi.featureauth.presentation.models.toValidationStatus
import com.revakovskyi.featureauth.presentation.signIn.GoogleAuthUiClient
import com.revakovskyi.featureauth.presentation.signIn.models.InputTextValidationStatus
import com.revakovskyi.featureauth.presentation.signIn.models.SignInResult
import com.revakovskyi.featureauth.presentation.signIn.models.SignInState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class AuthViewModel @Inject constructor(
    private val textValidationUseCase: TextValidationUseCase,
    private val googleAuthUiClient: GoogleAuthUiClient,
) : ViewModel() {

    var validation by mutableStateOf(InputTextValidationStatus())
        private set

    var signInState by mutableStateOf<SignInState>(SignInState.Default)
        private set

    fun verifyInputText(inputText: String, inputTextType: AuthInputTextType) {
        when (inputTextType) {
            AuthInputTextType.Login     ->  validateLogin(inputLogin = inputText)
            AuthInputTextType.Password  ->  validatePassword(inputPassword = inputText)
            AuthInputTextType.Name      ->  validateName(inputName = inputText)
            AuthInputTextType.Surname   ->  validateSurname(inputSurname = inputText)
            AuthInputTextType.Email     ->  validateEmail(inputEmail = inputText)
        }
    }

    private fun validateLogin(inputLogin: String) {
        textValidationUseCase(inputLogin, AuthInputTextType.Login.toInputText()).also { status ->
            validation = validation.copy(
                loginStatus = status.toValidationStatus()
            )
        }
    }

    private fun validatePassword(inputPassword: String) {
        textValidationUseCase(inputPassword, AuthInputTextType.Password.toInputText()).also { status ->
            validation = validation.copy(
                passwordStatus = status.toValidationStatus()
            )
        }
    }

    private fun validateName(inputName: String) {
        validation = validation.copy(nameStatus = ValidationStatus.Neutral)
        if (inputName.isNotEmpty()) {
            textValidationUseCase(inputName, AuthInputTextType.Name.toInputText()).also { status ->
                validation = validation.copy(
                    nameStatus = status.toValidationStatus()
                )
            }
        }
    }

    private fun validateSurname(inputSurname: String) {
        validation = validation.copy(surnameStatus = ValidationStatus.Neutral)
        if (inputSurname.isNotEmpty()) {
            textValidationUseCase(inputSurname, AuthInputTextType.Surname.toInputText()).also { status ->
                validation = validation.copy(
                    surnameStatus = status.toValidationStatus()
                )
            }
        }
    }

    private fun validateEmail(inputEmail: String) {
        textValidationUseCase(inputEmail, AuthInputTextType.Email.toInputText()).also { status ->
            validation = validation.copy(
                emailStatus = status.toValidationStatus()
            )
        }
    }

    fun verifyVerificationPassword(verificationPassword: String, password: String) {
        validation = validation.copy(verificationPasswordStatus = ValidationStatus.Neutral)
        if (verificationPassword.isNotEmpty()) {
            validation = validation.copy(verificationPasswordStatus =
                if (verificationPassword == password) ValidationStatus.Correct
                else ValidationStatus.Incorrect
            )
        }
    }

    fun launchIntentForSignIn(
        launcher: ManagedActivityResultLauncher<IntentSenderRequest, ActivityResult>,
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            val signInIntentSender = googleAuthUiClient.getIntentSender()
            launcher.launch(
                signInIntentSender?.let { IntentSenderRequest.Builder(it).build() }
            )
        }
    }

    fun signInViaGoogleAccountData(result: ActivityResult) {
        if (result.resultCode == Activity.RESULT_OK) {
            viewModelScope.launch(Dispatchers.IO) {
                val signInResult = googleAuthUiClient.signInWithGoogleData(
                    intent = result.data ?: return@launch
                )
                onSignInResult(signInResult)
            }
        }
    }

    private fun onSignInResult(result: SignInResult) {
        signInState = if (result.userData != null) SignInState.Success
        else SignInState.Error(result.errorMessage)
    }

    fun resetSignInState() {
        signInState = SignInState.Default
    }

    fun onSignOut() {
        viewModelScope.launch(Dispatchers.IO) {
            googleAuthUiClient.signOut()
        }
    }

    suspend fun isUserAlreadySignedIn(): Boolean =
        googleAuthUiClient.getSignedInUser() != null

}