package com.revakovskyi.featureauth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.presentation.ui.DivicePreviews
import com.revakovskyi.core.presentation.ui.theme.AppTypography
import com.revakovskyi.core.presentation.widgets.AppOutlinedEditTextField
import com.revakovskyi.core.presentation.widgets.AppTextRegular
import com.revakovskyi.core.presentation.widgets.AppTextTitle
import com.revakovskyi.core.presentation.widgets.OutlinedHintText
import com.revakovskyi.featureauth.R

@Composable
fun SingInScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    var answerInput by remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo_icon_no_bg),
                contentDescription = stringResource(id = R.string.logo_icon),
            )

            AppTextTitle(
                modifier = Modifier.padding(top = 64.dp),
                text = stringResource(R.string.welcome)
            )

            AppTextRegular(
                text = stringResource(R.string.please_sing_in_to_continue),
                style = AppTypography.bodyLarge
            )

            AppOutlinedEditTextField(
                value = answerInput,
                onValueChange = { answerInput = it },
                label = { OutlinedHintText(text = stringResource(R.string.phone_or_email)) },
                placeholder = { OutlinedHintText(text = stringResource(R.string.login_example)) },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Person icon"
                    )
                }
            )

        }

    }

}


@Composable
@DivicePreviews
fun ShowSingInScreen() {
    SingInScreen(navController = rememberNavController())
}