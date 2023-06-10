package com.revakovskyi.splashscreen.presentation

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

@Composable
fun SplashScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { navController.navigate("Screens.AuthScreen.route") },   // TODO: change route
        ) {
            Text(text = "To Auth Screen")
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ShowSplashScreen() {
    SplashScreen(navController = rememberNavController())
}