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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.presentation.ui.DivicePreviews
import com.revakovskyi.core.presentation.ui.theme.AppTypography
import com.revakovskyi.core.presentation.ui.theme.dimens
import com.revakovskyi.core.presentation.widgets.AppOutlinedEditTextField
import com.revakovskyi.core.presentation.widgets.ButtonRegular
import com.revakovskyi.core.presentation.widgets.OutlinedHintText
import com.revakovskyi.core.presentation.widgets.TextClickable
import com.revakovskyi.core.presentation.widgets.TextRegular
import com.revakovskyi.core.presentation.widgets.TextTitle
import com.revakovskyi.core.presentation.widgets.TextWithHorizontalBar
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

                TextClickable(
                    text = stringResource(R.string.forgot_password),
                    onClick = { /*TODO: open the appropriate screen*/ },
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
                        .size(64.dp)
                        .padding(top = MaterialTheme.dimens.large)
                        .clickable { /*TODO: open Google Sign In*/ }
                )

                TextRegular(
                    text = stringResource(R.string.don_t_have_an_account),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(top = MaterialTheme.dimens.large)
                )

                TextClickable(
                    text = stringResource(R.string.sing_up),
                    onClick = { /*TODO: open Sign Up screen*/ },
                    textStyle = MaterialTheme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.padding(bottom = MaterialTheme.dimens.small)
                )

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
        modifier = Modifier.padding(top = MaterialTheme.dimens.medium),
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