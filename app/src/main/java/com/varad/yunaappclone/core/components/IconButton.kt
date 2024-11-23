package com.varad.yunaappclone.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R

@Preview
@Composable
fun ShowIconButton() {
    IconButton(
        painter = painterResource(R.drawable.ic_back),
        onClick = {}
    )
}

@Composable
fun IconButton(
    painter: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    imageDescription: String = ""
) {
    Box(
        modifier =
        modifier.then(
            Modifier
                .clickable(onClick = onClick)
                .background(Color.Transparent, CircleShape)
                .border(1.dp, Color.White)
                .padding(4.dp),
        ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = imageDescription
        )
    }
}