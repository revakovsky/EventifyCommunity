package com.revakovskyi.featureauth.presentation.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import com.revakovskyi.core.util.Constants.DEFAULT_ANIMATION_DURATION
import com.revakovskyi.featureauth.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun InstructionsDialog(
    modifier: Modifier = Modifier,
    email: String,
    onConfirm: () -> Unit = { },
    onDismiss: () -> Unit = { },
    onResendMessageClicked: () -> Unit = { },
) {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val isDialogVisible = remember { mutableStateOf(false) }

    LaunchedEffect(Unit) { isDialogVisible.value = true }

    Dialog(
        onDismissRequest = {
            launchActionAndHideDialog(
                coroutineScope,
                isDialogVisible,
                action = onDismiss
            )
        }
    ) {

        AnimatedVisibility(
            visible = isDialogVisible.value,
            enter = createSlideInEnterAnimation(),
            exit = createSlideOutExitAnimation()
        ) {

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
                        modifier = Modifier.size(MaterialTheme.dimens.iconSize)
                    )

                    Text(
                        text = makeTextBoldStyle(email),
                        modifier = Modifier.padding(horizontal = MaterialTheme.dimens.medium),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )

                    ButtonRegular(
                        buttonText = stringResource(R.string.ok),
                        enabled = email.isNotEmpty(),
                        onClick = {
                            launchActionAndHideDialog(
                                coroutineScope,
                                isDialogVisible,
                                action = onConfirm
                            )
                        }
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

                            launchActionAndHideDialog(
                                coroutineScope,
                                isDialogVisible,
                                action = onResendMessageClicked
                            )
                        },
                        modifier = Modifier.padding(bottom = MaterialTheme.dimens.medium)
                    )

                }

            }

        }

    }

}

@Composable
private fun createSlideInEnterAnimation() =
    (slideInVertically(animationSpec = tween(durationMillis = DEFAULT_ANIMATION_DURATION))
            + fadeIn(animationSpec = tween(durationMillis = DEFAULT_ANIMATION_DURATION * 2)))

@Composable
private fun createSlideOutExitAnimation() =
    slideOutVertically(
        animationSpec = tween(durationMillis = DEFAULT_ANIMATION_DURATION),
        targetOffsetY = { it / 6 }
    ) + fadeOut(animationSpec = tween(durationMillis = DEFAULT_ANIMATION_DURATION))

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

private fun launchActionAndHideDialog(
    coroutineScope: CoroutineScope,
    isDialogVisible: MutableState<Boolean>,
    action: () -> Unit,
) {
    coroutineScope.launch {
        isDialogVisible.value = false
        delay(DEFAULT_ANIMATION_DURATION.toLong())
        action()
    }
}
