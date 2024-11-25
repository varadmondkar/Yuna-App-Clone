package com.varad.yunaappclone.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing

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
    modifier: Modifier = Modifier,
    imageDescription: String = "",
    onClick: () -> Unit
) {
    Box(
        modifier =
        modifier.then(
            Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Transparent, CircleShape)
                .border(1.dp, Color.White.copy(alpha = 0.5f), CircleShape)
                .clickable(onClick = onClick)
                .padding(LocalSpacing.current.small),
        ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = imageDescription
        )
    }
}