package com.revakovskyi.featureauth.presentation.signIn

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.revakovskyi.featureauth.viewModel.AuthViewModel

@Composable
internal fun SignInLauncher(
    viewModel: AuthViewModel,
    shouldRunSignIn: MutableState<Boolean>,
) {

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            viewModel.signInViaGoogleAccountData(result)
        }
    )

    if (shouldRunSignIn.value) {
        viewModel.launchIntentForSignIn(launcher)
        shouldRunSignIn.value = false
    }

}
