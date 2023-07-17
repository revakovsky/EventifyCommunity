package com.revakovskyi.featureauth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.presentation.ui.DivicePreviews
import com.revakovskyi.core.presentation.ui.theme.AppTypography
import com.revakovskyi.core.presentation.widgets.AppOutlinedEditTextField
import com.revakovskyi.core.presentation.widgets.OutlinedHintText
import com.revakovskyi.core.presentation.widgets.TextRegular
import com.revakovskyi.core.presentation.widgets.TextTitle
import com.revakovskyi.featureauth.R

@Composable
fun SingInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {

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
                .padding(16.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo_icon_no_bg),
                contentDescription = stringResource(id = R.string.logo_icon),
            )

            TextTitle(
                modifier = Modifier.padding(top = 64.dp),
                text = stringResource(R.string.welcome)
            )

            TextRegular(
                text = stringResource(R.string.please_sing_in_to_continue),
                style = AppTypography.bodyLarge
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {

                LoginInputField()

                PasswordInputField()

            }

        }

    }

}

@Composable
private fun LoginInputField() {
    var login by remember { mutableStateOf("") }
    var loginTipVisibility by remember { mutableStateOf(false) }
    var isLoginCorrect by remember { mutableStateOf(true) }

    AppOutlinedEditTextField(
        value = login,
        onValueChange = { inputText ->
            login = inputText

            if (login.startsWith('0')) {
                isLoginCorrect = false
            }

            if (login.isNotEmpty()) loginTipVisibility = true

            if (inputText.isEmpty()) {
                isLoginCorrect = true
                loginTipVisibility = false
            }
        },
        label = { OutlinedHintText(text = stringResource(R.string.phone_or_email)) },
        placeholder = { OutlinedHintText(text = stringResource(R.string.login_example)) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.person),
                contentDescription = stringResource(R.string.person_icon)
            )
        },
        trailingIcon = {
            if (loginTipVisibility) {
                Icon(
                    painter = if (isLoginCorrect) painterResource(id = R.drawable.tip)
                    else painterResource(id = R.drawable.incorrect),

                    contentDescription = if (isLoginCorrect) stringResource(R.string.correct)
                    else stringResource(R.string.incorrect),
                )
            }
        },
        isError = !isLoginCorrect,
        supportingText = {
            if (!isLoginCorrect) {
                OutlinedHintText(text = "Login is incorrect!")
            }
        },
    )
}

@Composable
private fun PasswordInputField() {
    var password by remember { mutableStateOf("") }
    var isPasswordInvisible by remember { mutableStateOf(true) }

    AppOutlinedEditTextField(
        modifier = Modifier.padding(top = 16.dp),
        value = password,
        onValueChange = { password = it },
        label = { OutlinedHintText(text = stringResource(R.string.password)) },
        placeholder = { OutlinedHintText(text = stringResource(R.string.password_example)) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.password_key),
                contentDescription = stringResource(R.string.password_icon)
            )
        },
        trailingIcon = {
            Icon(
                painter = if (isPasswordInvisible) painterResource(id = R.drawable.eye_closed)
                else painterResource(id = R.drawable.eye_opened),

                contentDescription = if (isPasswordInvisible) stringResource(R.string.entered_password_invisible)
                else stringResource(R.string.entered_password_visible),

                modifier = Modifier.clickable {
                    isPasswordInvisible = !isPasswordInvisible
                }
            )
        },
        visualTransformation = when (isPasswordInvisible) {
            true -> PasswordVisualTransformation()
            false -> VisualTransformation.None
        },
        imeAction = ImeAction.Done,
        autoCorrect = false,
    )
}


@Composable
@DivicePreviews
fun ShowSingInScreen() {
    SingInScreen(navController = rememberNavController())
}