package com.revakovskyi.featureauth.presentation.widgets

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.revakovskyi.core.presentation.widgets.OutlinedField
import com.revakovskyi.core.presentation.widgets.OutlinedHintText
import com.revakovskyi.featureauth.R

@Composable
fun LoginInputField(
    icon: Int = R.drawable.login,
    isLoginCorrect: () -> Boolean,
    isError: Boolean = false,
    loginOrPhoneNumber: (String) -> Unit,
) {
    var login by remember { mutableStateOf("") }
    var loginTipVisibility by remember { mutableStateOf(false) }

    val painterResourceId = when {
        isLoginCorrect() -> R.drawable.tip
        isError -> R.drawable.incorrect
        else -> null
    }

    OutlinedField(
        value = login,
        onValueChange = { inputText ->
            login = inputText
            loginOrPhoneNumber(login)
            loginTipVisibility =
                if (inputText.isEmpty()) false
                else isLoginCorrect()
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
            if (login.isNotEmpty()) {
                painterResourceId?.let {
                    painterResource(id = it)
                }?.let {
                    Icon(
                        painter = it,
                        contentDescription = if (isLoginCorrect()) {
                            stringResource(R.string.correct)
                        } else stringResource(R.string.incorrect),
                    )
                }
            }
        },
        isError = isError,
        supportingText = {
            if (isError) {
                OutlinedHintText(text = stringResource(R.string.login_is_incorrect))
            }
        },
    )
}
