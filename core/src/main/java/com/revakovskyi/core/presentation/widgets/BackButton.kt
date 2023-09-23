package com.revakovskyi.core.presentation.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.revakovskyi.core.R
import com.revakovskyi.core.presentation.ui.theme.dimens

@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Default.KeyboardArrowLeft,
) {

    IconButton(
        modifier = modifier.padding(MaterialTheme.dimens.medium),
        onClick = { onClick() }
    ) {
        Icon(
            imageVector = icon,
            contentDescription = stringResource(R.string.back),
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier
        )
    }

}