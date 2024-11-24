package com.varad.yunaappclone.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.components.ActionButton
import com.varad.yunaappclone.core.navigation.Route
import com.varad.yunaappclone.core.util.UiEvent

@Composable
fun HomeScreen(
    onNavigate: (UiEvent.Navigate) -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        ActionButton(
            text = stringResource(R.string.app_name),
            painter = null,
            onClick = {
                onNavigate(UiEvent.Navigate(Route.SUMMARY))
            },
            modifier = Modifier.align(Alignment.Center)
        )
    }
}