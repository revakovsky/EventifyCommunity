package com.revakovskyi.featureauth.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.revakovskyi.core.presentation.ui.BringIntoView
import com.revakovskyi.core.presentation.ui.theme.dimens
import com.revakovskyi.core.presentation.widgets.BackButton
import com.revakovskyi.core.presentation.widgets.LoadingAnimation
import com.revakovskyi.core.presentation.widgets.TextClickable
import com.revakovskyi.core.presentation.widgets.TextRegular
import com.revakovskyi.core.presentation.widgets.TextTitle
import com.revakovskyi.featureauth.R
import com.revakovskyi.featureauth.presentation.widgets.OtpTextFields
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun EmailAndPhoneVerificationScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    emailOrPhoneNumber: String?,
) {
    val isEmailWasPassed = emailOrPhoneNumber?.contains("@") == true
    var otpText by remember { mutableStateOf("") }
    var isOtpTextEnabled by remember { mutableStateOf(true) }
    var isLoadingAnimationVisible by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    val snackbarMessage = stringResource(id = R.string.we_have_resend_code)

    val scrollState = rememberScrollState()
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    BringIntoView(bringIntoViewRequester)

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { contentPadding ->

        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(state = scrollState)
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
                    text = stringResource(
                        id = if (isEmailWasPassed) R.string.verify_email
                        else R.string.verify_phone_number
                    ),
                    style = MaterialTheme.typography.titleSmall
                )

                TextRegular(
                    modifier = Modifier
                        .padding(top = MaterialTheme.dimens.large)
                        .padding(horizontal = MaterialTheme.dimens.large),
                    text = if (isEmailWasPassed) stringResource(
                        R.string.the_code_was_sent_to_the,
                        stringResource(id = R.string.email)
                    )
                    else stringResource(
                        R.string.the_code_was_sent_to_the,
                        stringResource(id = R.string.phone_number)
                    ),
                    textAlign = TextAlign.Center
                )

                TextRegular(
                    modifier = Modifier
                        .padding(top = MaterialTheme.dimens.medium)
                        .padding(horizontal = MaterialTheme.dimens.large),
                    text = emailOrPhoneNumber.toString(),
                    style = MaterialTheme.typography.bodyLarge,
                    textAlign = TextAlign.Center
                )

                OtpTextFields(
                    modifier = Modifier.padding(top = MaterialTheme.dimens.large),
                    otpText = otpText,
                    onOtpTextChange = { enteredCode, isOtpFull ->
                        isLoadingAnimationVisible = isOtpFull
                        if (isOtpFull) {
                            isOtpTextEnabled = false
                            otpText = enteredCode
                        }
                    },
                    enabled = isOtpTextEnabled,
                    bringIntoViewRequester = bringIntoViewRequester
                )

                TextRegular(
                    text = stringResource(R.string.didn_t_receive_the_code),
                    modifier = Modifier.padding(top = MaterialTheme.dimens.large)
                )

                TextClickable(
                    text = stringResource(R.string.resend_code),
                    onClick = {
                        coroutineScope.launch {
                            snackbarHostState.showSnackbar(snackbarMessage)
                        }
                    },
                )

                LoadingAnimation(
                    modifier = Modifier.padding(top = MaterialTheme.dimens.largest),
                    isVisible = isLoadingAnimationVisible
                )

            }
        }
    }

}
