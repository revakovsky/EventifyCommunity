package com.revakovskyi.featuresplash.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.navigation.MainRoutes

@Composable
fun SplashScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Splash screen")

        Spacer(modifier = modifier.height(50.dp))

        Button(
            onClick = { navController.navigate(MainRoutes.AUTH_ROUT) },
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