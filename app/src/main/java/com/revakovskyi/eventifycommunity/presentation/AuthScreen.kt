package com.revakovskyi.eventifycommunity.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.eventifycommunity.navGraph.Screens

@Composable
fun AuthScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { navController.navigate(Screens.SplashScreen.route) },
        ) {
            Text(text = "Back To Splash Screen")
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ShowAuthScreen() {
    AuthScreen(navController = rememberNavController())
}