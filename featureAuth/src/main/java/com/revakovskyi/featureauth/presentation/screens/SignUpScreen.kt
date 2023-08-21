package com.revakovskyi.featureauth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.revakovskyi.core.presentation.ui.theme.dimens
import com.revakovskyi.core.presentation.widgets.BackButton
import com.revakovskyi.core.presentation.widgets.ButtonRegular
import com.revakovskyi.core.presentation.widgets.TextClickable
import com.revakovskyi.core.presentation.widgets.TextLabel
import com.revakovskyi.core.presentation.widgets.TextRegular
import com.revakovskyi.core.presentation.widgets.TextTitle
import com.revakovskyi.core.presentation.widgets.TextWithHorizontalBar
import com.revakovskyi.featureauth.R
import com.revakovskyi.featureauth.navigation.Screens
import com.revakovskyi.featureauth.presentation.models.AuthInputTextType
import com.revakovskyi.featureauth.presentation.models.ValidationStatus
import com.revakovskyi.featureauth.presentation.widgets.LoginInputField
import com.revakovskyi.featureauth.presentation.widgets.NameInputField
import com.revakovskyi.featureauth.presentation.widgets.PasswordInputField
import com.revakovskyi.featureauth.viewModel.AuthViewModel

@Composable
internal fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AuthViewModel,
) {
    val scrollState = rememberScrollState()

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var emailOrPhoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var doubleCheckPassword by remember { mutableStateOf("") }

    LaunchedEffect(Unit) { scrollState.scrollTo(0) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(state = scrollState)
    ) {

        BackButton(onClick = { navController.popBackStack() })

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.dimens.medium)
        ) {

            Image(
                painter = painterResource(id = R.drawable.sign_up),
                contentDescription = stringResource(id = R.string.logo_icon),
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(MaterialTheme.dimens.iconSize)
                    .padding(top = MaterialTheme.dimens.medium)
            )

            TextTitle(
                modifier = Modifier.padding(top = MaterialTheme.dimens.small),
                text = stringResource(R.string.sign_up),
            )

            TextRegular(
                modifier = Modifier.padding(vertical = MaterialTheme.dimens.large),
                text = stringResource(R.string.create_your_account),
                style = MaterialTheme.typography.bodyLarge
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {

                NameInputField(
                    status = viewModel.nameValidationStatus,
                    inputName = { inputName ->
                        viewModel.apply {
                            verifyInputText(inputName, AuthInputTextType.Name)
                            name =
                                if (nameValidationStatus == ValidationStatus.Correct) inputName
                                else ""
                        }
                    }
                )

                NameInputField(
                    status = viewModel.surnameValidationStatus,
                    inputName = { inputSurname ->
                        viewModel.apply {
                            verifyInputText(inputSurname, AuthInputTextType.Surname)
                            surname =
                                if (surnameValidationStatus == ValidationStatus.Correct) inputSurname
                                else ""
                        }
                    },
                    label = stringResource(id = R.string.surname),
                    placeholder = stringResource(id = R.string.enter_your_surname),
                    icon = painterResource(id = R.drawable.double_person)
                )

                LoginInputField(
                    status = viewModel.loginValidationStatus,
                    inputLogin = { inputLogin ->
                        viewModel.apply {
                            verifyInputText(inputLogin, AuthInputTextType.Login)
                            emailOrPhoneNumber =
                                if (loginValidationStatus == ValidationStatus.Correct) inputLogin
                                else ""
                        }
                    },
                    icon = R.drawable.email
                )

                PasswordInputField(
                    status = viewModel.passwordValidationStatus,
                    inputPassword = { inputPassword ->
                        viewModel.apply {
                            verifyInputText(inputPassword, AuthInputTextType.Password)
                            password =
                                if (passwordValidationStatus == ValidationStatus.Correct) inputPassword
                                else ""
                        }
                    },
                    imeAction = ImeAction.Next
                )

                PasswordInputField(
                    status = viewModel.doubleCheckPasswordValidationStatus,
                    inputPassword = { inputPassword ->
                        viewModel.apply {
                            verifyDoubleCheckPassword(inputPassword, password)
                            doubleCheckPassword =
                                if (doubleCheckPasswordValidationStatus == ValidationStatus.Correct) inputPassword
                                else ""
                        }
                    },
                    label = stringResource(id = R.string.confirm_password),
                    supportingText = stringResource(id = R.string.passwords_mismatch)
                )

                TextLabel(
                    text = stringResource(R.string.confirm_terms_of_use),
                    textColor = MaterialTheme.colorScheme.outline,
                    modifier = Modifier
                        .widthIn(MaterialTheme.dimens.fieldMaxWidth)
                        .padding(horizontal = MaterialTheme.dimens.medium)
                        .padding(top = MaterialTheme.dimens.small)
                )

                ButtonRegular(
                    buttonText = stringResource(R.string.sign_up),
                    enabled = areFieldsNotEmpty(
                        name,
                        surname,
                        emailOrPhoneNumber,
                        password,
                        doubleCheckPassword
                    ),
                    onClick = {
                        navController.navigate(
                            Screens.EmailAndPhoneVerificationScreen.arguments(emailOrPhoneNumber)
                        )
                    }
                )

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
                        .clickable { /*TODO: open Google Sign In*/ }
                )

                TextRegular(
                    text = stringResource(R.string.already_have_an_account),
                    modifier = Modifier.padding(top = MaterialTheme.dimens.large)
                )

                TextClickable(
                    text = stringResource(R.string.sign_in),
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(bottom = MaterialTheme.dimens.medium)
                )

            }

        }

    }

}

@Composable
private fun areFieldsNotEmpty(
    name: String,
    surname: String,
    emailOrPhoneNumber: String,
    password: String,
    doubleCheckPassword: String,
) =
    name.isNotEmpty() &&
    surname.isNotEmpty() &&
    emailOrPhoneNumber.isNotEmpty() &&
    password.isNotEmpty() &&
    doubleCheckPassword.isNotEmpty()