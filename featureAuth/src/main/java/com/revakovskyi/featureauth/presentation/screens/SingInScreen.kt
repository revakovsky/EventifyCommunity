package com.revakovskyi.featureauth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.presentation.ui.theme.lightBackground
import com.revakovskyi.core.presentation.ui.theme.lightOnPrimary
import com.revakovskyi.core.presentation.ui.theme.lightOnSecondary
import com.revakovskyi.core.presentation.ui.theme.lightOnTertiary
import com.revakovskyi.core.presentation.ui.theme.lightPrimaryContainer
import com.revakovskyi.core.presentation.ui.theme.lightSurface
import com.revakovskyi.core.presentation.ui.theme.lightTertiaryContainer

@Composable
fun SingInScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    Box(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {

        Column {

        }

    }

}


@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ShowSingInScreen() {
    SingInScreen(navController = rememberNavController())
}