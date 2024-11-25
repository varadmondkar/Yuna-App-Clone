package com.varad.yunaappclone.ui.summary

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.ui.theme.Fraunces
import com.varad.yunaappclone.ui.theme.ScreenHeading

@Composable
fun ScreenTitleSection(
    title: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = LocalSpacing.current.extraSmall)
    ) {
        Text(
            text = title,
            style = ScreenHeading,
            fontFamily = Fraunces,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}