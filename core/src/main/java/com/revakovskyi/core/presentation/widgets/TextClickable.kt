package com.revakovskyi.core.presentation.widgets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.revakovskyi.core.presentation.ui.theme.AppTypography
import com.revakovskyi.core.presentation.ui.theme.dimens

@Composable
fun TextClickable(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    textAlign: TextAlign = TextAlign.End,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    textStyle: TextStyle = AppTypography.labelLarge.copy(
        textAlign = textAlign,
        color = textColor
    ),
) {

    ClickableText(
        text = AnnotatedString(text = text),
        onClick = { onClick() },
        modifier = modifier
            .widthIn(max = MaterialTheme.dimens.fieldMaxWidth)
            .fillMaxWidth()
            .padding(
                top = MaterialTheme.dimens.small,
                end = MaterialTheme.dimens.medium
            ),
        style = textStyle,
    )

}