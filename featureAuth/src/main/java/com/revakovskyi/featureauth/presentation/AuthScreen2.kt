package com.revakovskyi.featureauth.presentation

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
internal fun AuthScreen2(
    modifier: Modifier = Modifier,
    navController: NavController,
    text: String? = ""
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Auth screen 2")

        Spacer(modifier = Modifier.height(50.dp))

        text?.let {
            if (text.isNotEmpty()) Text(text = "The text from the AuthScreen is: \n$it")
            else Text(text = "Nothing was passed")
        }

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = { navController.popBackStack() },
        ) {
            Text(text = "Back")
        }

        Spacer(modifier = Modifier.height(50.dp))

        Button(
            onClick = {
                navController.popBackStack(
                    route = MainRoutes.AuthScreenRoute.route,
                    inclusive = true
                )
            },
        ) {
            Text(text = "Back to splash screen")
        }

    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ShowAuthScreen2() {
    AuthScreen2(navController = rememberNavController())
}