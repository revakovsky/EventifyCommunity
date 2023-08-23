package com.revakovskyi.featureauth.presentation.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.revakovskyi.core.presentation.ui.theme.dimens
import com.revakovskyi.core.presentation.widgets.TextRegular

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
internal fun OtpTextFields(
    modifier: Modifier = Modifier,
    otpText: String,
    otpCount: Int = 6,
    onOtpTextChange: (String, Boolean) -> Unit,
    enabled: Boolean = true,
    bringIntoViewRequester: BringIntoViewRequester = BringIntoViewRequester(),
) {
    val focusManager = LocalFocusManager.current
    var isOtpFull by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier.bringIntoViewRequester(bringIntoViewRequester),
        value = TextFieldValue(
            text = otpText,
            selection = TextRange(otpText.length)
        ),
        onValueChange = { textFieldValue ->
            if (textFieldValue.text.length <= otpCount) {
                isOtpFull = textFieldValue.text.length == otpCount

                onOtpTextChange.invoke(
                    textFieldValue.text,
                    isOtpFull
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword,
            imeAction = if (otpText.length < otpCount) ImeAction.Next else ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { focusManager.clearFocus() },
        ),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                repeat(otpCount) { index ->

                    CharView(
                        index = index,
                        text = otpText
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                }
            }
        },
        enabled = enabled,
    )
}

@Composable
private fun CharView(
    index: Int,
    text: String,
) {
    val isFocused = text.length == index

    val char = when {
        index == text.length -> "_"
        index > text.length -> ""
        else -> text[index].toString()
    }

    Box(
        modifier = Modifier
            .size(40.dp, 48.dp)
            .border(
                width = if (isFocused) 2.dp else 1.dp,
                color = if (isFocused) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline,
                shape = MaterialTheme.shapes.small
            )
            .padding(MaterialTheme.dimens.smallest),
        contentAlignment = Alignment.Center
    ) {

        TextRegular(
            text = char,
            style = MaterialTheme.typography.bodyLarge,
            textColor = MaterialTheme.colorScheme.primary,
        )

    }
}
