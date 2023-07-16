package com.revakovskyi.core.presentation.widgets

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.revakovskyi.core.presentation.ui.theme.AppTypography

@Composable
fun OutlinedHintText(
    text: String,
) {

    Text(
        text = text,
        fontSize = 16.sp,
        style = AppTypography.bodyMedium
    )

}