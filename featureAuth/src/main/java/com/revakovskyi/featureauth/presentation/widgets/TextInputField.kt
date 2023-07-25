package com.revakovskyi.featureauth.presentation.widgets

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.revakovskyi.core.presentation.widgets.OutlinedField
import com.revakovskyi.core.presentation.widgets.OutlinedHintText
import com.revakovskyi.featureauth.R

@Composable
fun TextInputField(
    label: String = stringResource(R.string.name),
    placeholder: String = stringResource(R.string.enter_your_name),
    icon: Painter = painterResource(id = R.drawable.person),
) {
    var name by remember { mutableStateOf("") }
    var nameTipVisibility by remember { mutableStateOf(false) }
    var isNameCorrect by remember { mutableStateOf(true) }

    OutlinedField(
        modifier = Modifier,
        value = name,
        onValueChange = { inputText ->
            name = inputText

            if (name.startsWith('0')) {
                isNameCorrect = false
            }

            if (name.isNotEmpty()) nameTipVisibility = true

            if (inputText.isEmpty()) {
                isNameCorrect = true
                nameTipVisibility = false
            }
        },
        label = { OutlinedHintText(text = label) },
        placeholder = { OutlinedHintText(text = placeholder) },
        leadingIcon = {
            Icon(
                painter = icon,
                contentDescription = stringResource(R.string.person_icon)
            )
        },
        trailingIcon = {
            if (nameTipVisibility) {
                Icon(
                    painter = if (isNameCorrect) painterResource(id = R.drawable.tip)
                    else painterResource(id = R.drawable.incorrect),

                    contentDescription = if (isNameCorrect) stringResource(R.string.correct)
                    else stringResource(R.string.incorrect),
                )
            }
        },
        isError = !isNameCorrect,
        supportingText = {
            if (!isNameCorrect) {
                OutlinedHintText(text = stringResource(R.string.the_input_text_is_incorrect))
            }
        },
    )
}
