package com.revakovskyi.core.presentation.ui

import android.view.ViewTreeObserver
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalView
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BringIntoView(bringIntoViewRequester: BringIntoViewRequester) {
    val view = LocalView.current
    val coroutineScope = rememberCoroutineScope()

    DisposableEffect(view) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            coroutineScope.launch {
                bringIntoViewRequester.bringIntoView()
            }
        }
        view.viewTreeObserver.addOnGlobalLayoutListener(listener)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }
}
