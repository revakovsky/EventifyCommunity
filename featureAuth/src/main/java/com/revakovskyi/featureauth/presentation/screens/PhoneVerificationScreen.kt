package com.revakovskyi.featureauth.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.revakovskyi.core.presentation.ui.DivicePreviews
import com.revakovskyi.core.presentation.ui.theme.dimens
import com.revakovskyi.core.presentation.widgets.BackButton
import com.revakovskyi.core.presentation.widgets.TextRegular
import com.revakovskyi.core.presentation.widgets.TextTitle
import com.revakovskyi.featureauth.R
import com.revakovskyi.featureauth.presentation.widgets.OtpTextFields

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PhoneVerificationScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    phoneNumber: String?,
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    var otpText by remember { mutableStateOf("") }

    LaunchedEffect(Unit) { keyboardController?.hide() }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {

        BackButton(onClick = { navController.popBackStack() })

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.dimens.medium)
        ) {

            Image(
                painter = painterResource(id = R.drawable.verificaiton),
                contentDescription = stringResource(id = R.string.logo_icon),
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(MaterialTheme.dimens.iconSize)
                    .padding(top = MaterialTheme.dimens.medium)
            )

            TextTitle(
                modifier = Modifier
                    .padding(horizontal = MaterialTheme.dimens.medium)
                    .padding(top = MaterialTheme.dimens.medium),
                text = stringResource(R.string.verify_phone_number),
                style = MaterialTheme.typography.titleSmall
            )

            TextRegular(
                modifier = Modifier
                    .padding(top = MaterialTheme.dimens.large)
                    .padding(horizontal = MaterialTheme.dimens.large),
                text = stringResource(R.string.the_code_was_sent_to_the_number),
                textAlign = TextAlign.Center
            )

            TextRegular(
                modifier = Modifier
                    .padding(top = MaterialTheme.dimens.medium)
                    .padding(horizontal = MaterialTheme.dimens.large),
                text = phoneNumber.toString(),
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center
            )

            OtpTextFields(
                modifier = Modifier.padding(top = MaterialTheme.dimens.large),
                otpText = otpText,
                onOtpTextChange = { enteredCode, isOtpFull ->
                    otpText = enteredCode
                }
            )

        }
    }
}


@Composable
@DivicePreviews
fun ShowPhoneVerificationScreen() {
    PhoneVerificationScreen(
        navController = rememberNavController(), phoneNumber = "+38 050 111 222 33"
    )
}