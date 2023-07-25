package com.revakovskyi.core.presentation.widgets

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun OutlinedHintText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    textAlign: TextAlign = TextAlign.Start,
) {

    Text(
        modifier = modifier,
        text = text,
        style = style.copy(
            textAlign = textAlign
        )
    )

}