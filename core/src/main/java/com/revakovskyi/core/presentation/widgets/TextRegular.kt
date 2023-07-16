package com.revakovskyi.core.presentation.widgets

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.revakovskyi.core.presentation.ui.theme.AppTypography

@Composable
fun AppTextRegular(
    text: String,
    style: TextStyle = AppTypography.bodyMedium,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
) {

    Text(
        text = text,
        style = style,
        color = textColor
    )

}