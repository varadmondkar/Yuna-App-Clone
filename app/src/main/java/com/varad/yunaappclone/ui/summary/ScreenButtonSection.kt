package com.varad.yunaappclone.ui.summary

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.components.PrimaryButton

@Composable
fun ScreenButtonSection(
    onScreenButtonClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        PrimaryButton(
            text = stringResource(R.string.continue_session_title),
            modifier = Modifier.align(Alignment.Center),
            onClick = onScreenButtonClick
        )
    }
}