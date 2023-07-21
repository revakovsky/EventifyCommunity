package com.revakovskyi.featureauth.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

@Composable
fun PhoneVerificationScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    phoneNumber: String?,
) {

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

            TextTitle(
                modifier = Modifier.padding(top = MaterialTheme.dimens.medium),
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

        }
    }
}

@Composable
@DivicePreviews
fun ShowPhoneVerificationScreen() {
    PhoneVerificationScreen(
        navController = rememberNavController(),
        phoneNumber = "+38 050 111 222 33"
    )
}