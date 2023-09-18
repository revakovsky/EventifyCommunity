package com.revakovskyi.core.presentation.widgets

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import com.revakovskyi.core.presentation.ui.theme.dimens
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TextClickable(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    textStyle: TextStyle = MaterialTheme.typography.displayMedium,
    textAlign: TextAlign = TextAlign.Center,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
) {

    val delayTime = 100L
    val label = "TextColorTransition"

    var clicked by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val transition = updateTransition(targetState = clicked, label = label)

    val textColorState = transition.animateColor(label = label) {
        if (it) MaterialTheme.colorScheme.tertiaryContainer
        else textColor
    }


    ClickableText(
        text = AnnotatedString(text = text),
        onClick = {
            clicked = true
            coroutineScope.launch {
                delay(delayTime)
                clicked = false
                onClick()
            }
        },
        modifier = modifier
            .widthIn(max = MaterialTheme.dimens.inputFieldsMaxWidth)
            .fillMaxWidth()
            .padding(
                top = MaterialTheme.dimens.small,
            ),
        style = textStyle.copy(
            textAlign = textAlign,
            color = textColorState.value,
            textDecoration = TextDecoration.Underline
        ),
    )

}