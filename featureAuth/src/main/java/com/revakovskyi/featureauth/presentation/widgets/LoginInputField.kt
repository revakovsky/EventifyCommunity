package com.revakovskyi.featureauth.presentation.widgets

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.revakovskyi.core.presentation.widgets.AppOutlinedEditTextField
import com.revakovskyi.core.presentation.widgets.OutlinedHintText
import com.revakovskyi.featureauth.R

@Composable
fun LoginInputField(
    icon: Int = R.drawable.login,
    enteredText: (String) -> Unit,
) {
    var login by remember { mutableStateOf("") }
    var loginTipVisibility by remember { mutableStateOf(false) }
    var isLoginCorrect by remember { mutableStateOf(true) }

    AppOutlinedEditTextField(
        value = login,
        onValueChange = { inputText ->
            login = inputText
            enteredText(login)

            // TODO: create verification and put it into the domain
            if (login.startsWith('0')) {
                isLoginCorrect = false
                loginTipVisibility = true
            }

            if (login.isNotEmpty() && (login.contains('@') || login.contains("+380"))) {
                loginTipVisibility = true
            }

            if (inputText.isEmpty()) {
                isLoginCorrect = true
                loginTipVisibility = false
            }
        },
        label = { OutlinedHintText(text = stringResource(R.string.phone_or_email)) },
        placeholder = { OutlinedHintText(text = stringResource(R.string.login_example)) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
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
                OutlinedHintText(text = stringResource(R.string.login_is_incorrect))
            }
        },
    )
}
