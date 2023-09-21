package com.revakovskyi.featureauth.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.core.presentation.ui.BringIntoView
import com.revakovskyi.core.presentation.ui.theme.dimens
import com.revakovskyi.core.presentation.widgets.ButtonRegular
import com.revakovskyi.core.presentation.widgets.ProgressDialog
import com.revakovskyi.core.presentation.widgets.TextClickable
import com.revakovskyi.core.presentation.widgets.TextRegular
import com.revakovskyi.core.presentation.widgets.TextTitle
import com.revakovskyi.featureauth.R
import com.revakovskyi.featureauth.navigation.Screens
import com.revakovskyi.featureauth.presentation.models.AuthInputTextType
import com.revakovskyi.featureauth.presentation.models.ProgressDialogState
import com.revakovskyi.featureauth.presentation.models.ValidationStatus
import com.revakovskyi.featureauth.presentation.signIn.models.SignInState
import com.revakovskyi.featureauth.presentation.widgets.LoginInputField
import com.revakovskyi.featureauth.presentation.widgets.PasswordInputField
import com.revakovskyi.featureauth.presentation.widgets.TextWithHorizontalBar
import com.revakovskyi.featureauth.viewModel.AuthViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AuthViewModel,
    onGoogleSingInClick: () -> Unit,
) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val snackbarHostState = remember { SnackbarHostState() }
    val scrollState = rememberScrollState()
    val bringIntoViewRequester = remember { BringIntoViewRequester() }

    BringIntoView(bringIntoViewRequester)

    LaunchedEffect(key1 = viewModel.signInState) {
        when (val state = viewModel.signInState) {
            SignInState.Success -> {
                navController.navigate(MainRoutes.ProfileScreenRoute.route)
                viewModel.resetSignInState()
            }
            is SignInState.Error -> state.message?.let { error ->
                snackbarHostState.showSnackbar(message = error)
            }
            else -> Unit
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { contentPadding ->

        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(state = scrollState)
                .padding(contentPadding)
        ) {

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MaterialTheme.dimens.medium)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.logo_icon_no_bg),
                    contentDescription = stringResource(id = R.string.logo_icon),
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .clipToBounds()
                        .padding(top = MaterialTheme.dimens.medium)
                )

                TextTitle(
                    modifier = Modifier.padding(top = MaterialTheme.dimens.large),
                    text = stringResource(R.string.welcome)
                )

                TextRegular(
                    modifier = Modifier.padding(MaterialTheme.dimens.medium),
                    text = stringResource(R.string.please_sign_in_to_continue),
                    style = MaterialTheme.typography.bodyLarge
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = MaterialTheme.dimens.medium)
                ) {

                    LoginInputField(
                        status = viewModel.validation.loginStatus,
                        inputLogin = { inputLogin ->
                            viewModel.apply {
                                verifyInputText(inputLogin, AuthInputTextType.Login)
                                login =
                                    if (validation.loginStatus == ValidationStatus.Correct) inputLogin
                                    else ""
                            }
                        },
                    )

                    PasswordInputField(
                        status = viewModel.validation.passwordStatus,
                        inputPassword = { inputPassword ->
                            viewModel.apply {
                                verifyInputText(inputPassword, AuthInputTextType.Password)
                                password =
                                    if (validation.passwordStatus == ValidationStatus.Correct) inputPassword
                                    else ""
                            }
                        }
                    )

                    TextClickable(
                        text = stringResource(R.string.forgot_password),
                        onClick = { navController.navigate(Screens.ForgotPasswordScreen.route) },
                        textStyle = MaterialTheme.typography.labelLarge,
                        textAlign = TextAlign.End,
                        modifier = Modifier.padding(end = MaterialTheme.dimens.medium)
                    )

                    ButtonRegular(
                        buttonText = stringResource(R.string.sign_in),
                        enabled = areFieldsNotEmpty(login, password),
                        onClick = {
                            /*TODO: make sign in and hide the dialog*/
                        },
                        bringIntoViewRequester = bringIntoViewRequester
                    )
                }

                TextWithHorizontalBar(
                    text = stringResource(R.string.or_sign_in_using),
                    modifier = Modifier.padding(top = MaterialTheme.dimens.large)
                )

                Image(
                    painter = painterResource(id = R.drawable.google_icon),
                    contentDescription = stringResource(R.string.google),
                    modifier = Modifier
                        .height(64.dp)
                        .padding(top = MaterialTheme.dimens.large)
                        .clip(shape = CircleShape)
                        .clickable { onGoogleSingInClick() }
                )

                TextRegular(
                    text = stringResource(R.string.don_t_have_an_account),
                    modifier = Modifier.padding(top = MaterialTheme.dimens.large),
                    textAlign = TextAlign.Center
                )

                TextClickable(
                    text = stringResource(R.string.sign_up),
                    onClick = { navController.navigate(Screens.SingUpScreen.route) },
                    modifier = Modifier.padding(bottom = MaterialTheme.dimens.medium)
                )

            }

        }

    }

    if (viewModel.progressDialogState == ProgressDialogState.Visible) ProgressDialog()

}

private fun areFieldsNotEmpty(login: String, password: String) =
    login.isNotEmpty() && password.isNotEmpty()
