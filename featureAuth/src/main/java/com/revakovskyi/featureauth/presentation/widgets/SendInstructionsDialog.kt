package com.revakovskyi.featureauth.presentation.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import com.revakovskyi.core.presentation.ui.theme.dimens
import com.revakovskyi.core.presentation.widgets.ButtonRegular
import com.revakovskyi.core.presentation.widgets.TextClickable
import com.revakovskyi.core.presentation.widgets.TextRegular
import com.revakovskyi.core.presentation.widgets.TextTitle
import com.revakovskyi.featureauth.R

@Composable
internal fun SendInstructionsDialog(
    modifier: Modifier = Modifier,
    email: String,
    onConfirm: () -> Unit = { },
    onDismiss: () -> Unit = { },
    onResendMessageClicked: () -> Unit = { },
) {

    Dialog(onDismissRequest = { onDismiss() }) {

        Box(
            modifier = modifier
                .wrapContentSize()
                .background(
                    color = MaterialTheme.colorScheme.onSecondary,
                    shape = MaterialTheme.shapes.large
                ),
            contentAlignment = Alignment.TopCenter
        ) {

            Card(
                modifier = modifier,
                elevation = CardDefaults.elevatedCardElevation(),
            ) {

            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(MaterialTheme.dimens.medium)
            ) {

                TextTitle(
                    modifier = Modifier.padding(top = MaterialTheme.dimens.medium),
                    text = stringResource(R.string.check_your_email),
                    style = MaterialTheme.typography.titleSmall
                )

                Image(
                    painter = painterResource(id = R.drawable.check_email),
                    contentDescription = stringResource(R.string.check_email_logo),
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .size(MaterialTheme.dimens.iconSize)
                )

                Text(
                    text = makeTextBoldStyle(email),
                    modifier = Modifier.padding(
                        horizontal = MaterialTheme.dimens.medium,
                    ),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground
                )

                ButtonRegular(
                    buttonText = stringResource(R.string.ok),
                    enabled = email.isNotEmpty(),
                    onClick = { onConfirm() }
                )

                TextRegular(
                    text = stringResource(R.string.didn_t_receive_instructions),
                    modifier = Modifier.padding(top = MaterialTheme.dimens.large),
                    textAlign = TextAlign.Center
                )

                TextClickable(
                    text = stringResource(R.string.resend_message),
                    onClick = {
                        /*TODO: send message again*/
                        onResendMessageClicked()
                    },
                    modifier = Modifier.padding(bottom = MaterialTheme.dimens.medium)
                )

            }

        }

    }

}

@Composable
private fun makeTextBoldStyle(email: String): AnnotatedString {
    val text = stringResource(R.string.we_have_sent_you_instructions, email)
    return buildAnnotatedString {
        append(text)
        val startIndex = text.indexOf(email)
        val endIndex = startIndex + email.length
        addStyle(
            style = SpanStyle(fontWeight = FontWeight.Bold),
            start = startIndex,
            end = endIndex
        )
    }
}
