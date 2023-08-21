package com.revakovskyi.featureauth.presentation.widgets

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import com.revakovskyi.core.presentation.widgets.OutlinedField
import com.revakovskyi.core.presentation.widgets.OutlinedHintText
import com.revakovskyi.featureauth.R
import com.revakovskyi.featureauth.presentation.models.ValidationStatus

@Composable
internal fun LoginInputField(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.login,
    status: ValidationStatus,
    inputLogin: (String) -> Unit,
    label: String = stringResource(R.string.phone_or_email),
    placeholder: String = stringResource(R.string.login_example),
    supportingText: String = stringResource(R.string.login_is_incorrect),
    imeAction: ImeAction = ImeAction.Next,
) {
    var login by remember { mutableStateOf("") }

    val painterResourceId = when (status) {
        ValidationStatus.Correct -> R.drawable.tip
        ValidationStatus.Incorrect -> R.drawable.incorrect
        ValidationStatus.Neutral -> null
    }

    OutlinedField(
        modifier = modifier,
        value = login,
        onValueChange = { inputText ->
            login = inputText.trim()
            inputLogin(login)
        },
        label = { OutlinedHintText(text = label) },
        placeholder = { OutlinedHintText(text = placeholder) },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = stringResource(R.string.person_icon)
            )
        },
        trailingIcon = {
            if (login.isNotEmpty()) {
                painterResourceId?.let { resourceId -> painterResource(id = resourceId) }
                    ?.let { painter ->
                        Icon(
                            painter = painter,
                            contentDescription =
                            if (status == ValidationStatus.Correct) stringResource(R.string.correct)
                            else stringResource(R.string.incorrect),
                        )
                    }
            }
        },
        isError = status == ValidationStatus.Incorrect,
        supportingText = {
            if (status == ValidationStatus.Incorrect) {
                OutlinedHintText(text = supportingText)
            }
        },
        imeAction = imeAction,
    )
}
