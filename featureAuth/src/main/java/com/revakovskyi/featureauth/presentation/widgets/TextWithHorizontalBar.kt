package com.revakovskyi.featureauth.presentation.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.revakovskyi.core.presentation.ui.theme.dimens
import com.revakovskyi.core.presentation.widgets.TextRegular

@Composable
fun TextWithHorizontalBar(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = MaterialTheme.typography.bodySmall,
    dividerMaxWidth: Dp = 500.dp,
    dividerMaxHeight: Dp = 1.dp,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    spaceBetweenTextAndBar: Dp = MaterialTheme.dimens.medium,
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = MaterialTheme.dimens.medium),
        contentAlignment = Alignment.Center
    ) {

        Divider(
            modifier = Modifier
                .width(dividerMaxWidth)
                .height(dividerMaxHeight)
        )

        TextRegular(
            text = text,
            style = style,
            modifier = Modifier
                .background(color = backgroundColor)
                .padding(horizontal = spaceBetweenTextAndBar)
        )

    }

}