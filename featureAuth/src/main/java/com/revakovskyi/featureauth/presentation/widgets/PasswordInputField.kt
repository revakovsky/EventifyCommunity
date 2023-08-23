package com.revakovskyi.featureauth.presentation.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.revakovskyi.core.presentation.widgets.OutlinedField
import com.revakovskyi.core.presentation.widgets.OutlinedHintText
import com.revakovskyi.featureauth.R
import com.revakovskyi.featureauth.presentation.models.ValidationStatus

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun PasswordInputField(
    status: ValidationStatus,
    inputPassword: (String) -> Unit,
    label: String = stringResource(R.string.password),
    imeAction: ImeAction = ImeAction.Done,
    supportingText: String = stringResource(R.string.password_should_contain),
    bringIntoViewRequester: BringIntoViewRequester = BringIntoViewRequester(),
) {
    var password by remember { mutableStateOf("") }
    var isPasswordInvisible by remember { mutableStateOf(true) }

    OutlinedField(
        value = password,
        onValueChange = { inputText ->
            password = inputText.trim()
            inputPassword(password)
        },
        label = { OutlinedHintText(text = label) },
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

                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { isPasswordInvisible = !isPasswordInvisible }
            )
        },
        visualTransformation = when (isPasswordInvisible) {
            true -> PasswordVisualTransformation()
            false -> VisualTransformation.None
        },
        imeAction = imeAction,
        autoCorrect = false,
        supportingText = {
            if (status == ValidationStatus.Incorrect) {
                OutlinedHintText(
                    text = supportingText,
                    style = MaterialTheme.typography.labelLarge
                )
            }
        },
        bringIntoViewRequester = bringIntoViewRequester,
    )
}
