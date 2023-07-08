package com.revakovskyi.featureauth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.navigation.MainRoutes
import com.revakovskyi.featureauth.navigation.Screens

@Composable
internal fun AuthScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

    var text by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Auth screen")

        Spacer(modifier = Modifier.height(50.dp))

        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = { navController.navigate(MainRoutes.ProfileScreenRoute.arguments(text)) },
        ) {
            Text(text = "To Profile Screen")
        }

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = { navController.navigate(Screens.AuthScreen2.arguments(text)) },
        ) {
            Text(text = "To Auth Screen 2")
        }

    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ShowAuthScreen() {
    AuthScreen(navController = rememberNavController())
}