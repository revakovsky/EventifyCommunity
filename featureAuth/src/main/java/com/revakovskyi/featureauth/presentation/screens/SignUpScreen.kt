package com.revakovskyi.featureauth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.presentation.ui.DivicePreviews
import com.revakovskyi.core.presentation.ui.theme.dimens
import com.revakovskyi.core.presentation.widgets.BackButton
import com.revakovskyi.core.presentation.widgets.TextRegular
import com.revakovskyi.core.presentation.widgets.TextTitle
import com.revakovskyi.featureauth.R
import com.revakovskyi.featureauth.presentation.widgets.NameInputField

@Suppress("LongMethod", "FunctionNaming", "MagicNumber", "NewLineAtEndOfFile")
@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        BackButton(onClick = { navController.popBackStack() })

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.dimens.medium)
        ) {

            TextTitle(
                modifier = Modifier.padding(top = MaterialTheme.dimens.large),
                text = stringResource(R.string.sign_up)
            )

            TextRegular(
                modifier = Modifier.padding(MaterialTheme.dimens.medium),
                text = "Create your Account",
                style = MaterialTheme.typography.bodyLarge
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {

                NameInputField()

                NameInputField(
                    label = stringResource(R.string.surname),
                    placeholder = stringResource(R.string.enter_your_surname),
                    icon = painterResource(id = R.drawable.double_person)
                )

            }

        }

    }

}

@Suppress("LongMethod", "FunctionNaming", "MagicNumber", "NewLineAtEndOfFile")
@Composable
@DivicePreviews
fun ShowSingUpScreen() {
    SignUpScreen(navController = rememberNavController())
}