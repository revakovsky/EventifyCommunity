package com.revakovskyi.core.presentation.widgets

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.revakovskyi.core.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int? = null,

    showNavigationIcon: Boolean = true,
    navigationIcon: ImageVector = Icons.Default.KeyboardArrowLeft,
    @StringRes navigationIconDescription: Int = R.string.back,
    onNavigationIconClick: () -> Unit = { },

    showEndTextButton: Boolean = false,
    @StringRes endTextButtonText: Int? = null,
    onEndTextButtonClick: () -> Unit = { },

    showEndIcon: Boolean = false,
    endIcon: ImageVector = Icons.Default.Delete,
    @StringRes endIconDescription: Int = R.string.delete,
    onEndIconClick: () -> Unit = { },

    scrollBehaviour: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
) {

    TopAppBar(
        modifier = modifier,
        title = {
            if (titleRes != null) TextRegular(
                text = stringResource(id = titleRes),
                style = MaterialTheme.typography.bodyLarge
            )
        },
        navigationIcon = {
            if (showNavigationIcon) IconButton(onClick = { onNavigationIconClick() }) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = stringResource(navigationIconDescription),
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                )
            }
        },
        actions = {

            if (showEndTextButton) {
                if (endTextButtonText != null) Text(
                    modifier = Modifier.clickable { onEndTextButtonClick() },
                    text = stringResource(id = endTextButtonText),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary,
                )
            }

            if (showEndIcon) IconButton(onClick = { onEndIconClick() }) {
                Icon(
                    imageVector = endIcon,
                    contentDescription = stringResource(endIconDescription),
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.background),
        scrollBehavior = scrollBehaviour
    )

}