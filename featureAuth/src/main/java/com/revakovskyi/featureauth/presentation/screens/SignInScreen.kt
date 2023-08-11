package com.revakovskyi.featureauth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.revakovskyi.core.presentation.ui.theme.dimens
import com.revakovskyi.core.presentation.widgets.ButtonRegular
import com.revakovskyi.core.presentation.widgets.TextClickable
import com.revakovskyi.core.presentation.widgets.TextRegular
import com.revakovskyi.core.presentation.widgets.TextTitle
import com.revakovskyi.core.presentation.widgets.TextWithHorizontalBar
import com.revakovskyi.featureauth.R
import com.revakovskyi.featureauth.navigation.Screens
import com.revakovskyi.featureauth.presentation.models.AuthInputTextType
import com.revakovskyi.featureauth.presentation.models.ValidationStatus
import com.revakovskyi.featureauth.presentation.widgets.LoginInputField
import com.revakovskyi.featureauth.presentation.widgets.PasswordInputField
import com.revakovskyi.featureauth.viewModel.AuthViewModel

@Composable
internal fun SignInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: AuthViewModel,
) {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
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
                    .weight(1f, fill = false)
                    .aspectRatio(1.1f)
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
                    status = viewModel.loginValidationStatus,
                    inputLogin = { inputLogin ->
                        if (inputLogin.isEmpty()) login = ""
                        viewModel.apply {
                            verifyInputText(inputLogin, AuthInputTextType.Login)
                            if (loginValidationStatus == ValidationStatus.Correct) {
                                login = inputLogin
                            }
                        }
                    }
                )

                PasswordInputField(
                    status = viewModel.passwordValidationStatus,
                    inputPassword = { inputPassword ->
                        if (inputPassword.isEmpty()) password = ""
                        viewModel.apply {
                            verifyInputText(inputPassword, AuthInputTextType.Password)
                            if (passwordValidationStatus == ValidationStatus.Correct) {
                                password = inputPassword
                            }
                        }
                    }
                )

                TextClickable(
                    text = stringResource(R.string.forgot_password),
                    onClick = { /*TODO: open the appropriate screen*/ },
                    textStyle = MaterialTheme.typography.labelLarge,
                    textAlign = TextAlign.End
                )

                ButtonRegular(
                    buttonText = stringResource(R.string.sign_in),
                    onClick = { /*TODO: process click*/ }
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
                    text = stringResource(R.string.don_t_have_an_account),
                    modifier = Modifier.padding(top = MaterialTheme.dimens.large)
                )

                TextClickable(
                    text = stringResource(R.string.sign_up),
                    onClick = { navController.navigate(Screens.SingUpScreen.route) },
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = MaterialTheme.dimens.medium)
                )

            }

        }

    }

}
