package com.revakovskyi.core.presentation.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.revakovskyi.core.presentation.ui.theme.dimens

@Composable
fun ButtonRegular(
    buttonText: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {

    Button(
        onClick = { onClick() },
        modifier = modifier
            .width(MaterialTheme.dimens.buttonWidth)
            .padding(top = MaterialTheme.dimens.large),
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.textButtonColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
            disabledContainerColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f),
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = MaterialTheme.dimens.zero,
            pressedElevation = MaterialTheme.dimens.smallest
        ),
        enabled = enabled
    ) {
        TextRegular(
            text = buttonText,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            )
        )
    }
}