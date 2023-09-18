package com.revakovskyi.featureauth.presentation.signIn

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import com.revakovskyi.featureauth.viewModel.AuthViewModel

@Composable
internal fun SignInLauncher(
    viewModel: AuthViewModel,
    shouldRunGoogleSignIn: Boolean,
    onDismissSignInRequest: () -> Unit,
) {

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = { result ->
            viewModel.signInViaGoogleAccountData(result)
        }
    )

    if (shouldRunGoogleSignIn) {
        viewModel.launchIntentForSignIn(launcher)
        onDismissSignInRequest()
    }

}
