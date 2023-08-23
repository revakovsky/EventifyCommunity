package com.revakovskyi.featureauth.presentation.widgets

import androidx.compose.foundation.ExperimentalFoundationApi
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
import com.revakovskyi.featureauth.presentation.models.ValidationStatus

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun NameInputField(
    label: String = stringResource(R.string.name),
    placeholder: String = stringResource(R.string.enter_your_name),
    icon: Painter = painterResource(id = R.drawable.person),
    status: ValidationStatus,
    inputName: (String) -> Unit,
) {
    var name by remember { mutableStateOf("") }

    val painterResourceId = when (status) {
        ValidationStatus.Correct -> R.drawable.tip
        ValidationStatus.Incorrect -> R.drawable.incorrect
        ValidationStatus.Neutral -> null
    }

    OutlinedField(
        modifier = Modifier,
        value = name,
        onValueChange = { inputText ->
            name = inputText.replaceFirstChar { it.uppercase() }
            inputName(name)
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
            if (name.isNotEmpty()) {
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
                OutlinedHintText(text = stringResource(R.string.text_is_incorrect))
            }
        },
    )
}
