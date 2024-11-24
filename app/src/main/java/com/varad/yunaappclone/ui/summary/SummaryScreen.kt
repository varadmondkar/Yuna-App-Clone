package com.varad.yunaappclone.ui.summary

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varad.yunaappclone.core.util.UiEvent

@Composable
fun SummaryScreen(
    viewModel: SummaryViewModel,
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    val screenData = viewModel.screenData

    LaunchedEffect(true) {
        viewModel.getSummaryScreenData()
    }

    Log.d("SCREEN", "SummaryScreen: $screenData")
}