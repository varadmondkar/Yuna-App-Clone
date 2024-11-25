package com.varad.yunaappclone.ui.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.core.components.ActionButton
import com.varad.yunaappclone.ui.theme.Black20
import com.varad.yunaappclone.ui.theme.Fraunces
import com.varad.yunaappclone.ui.theme.HeadingMedium

@Preview
@Composable
fun ShowShareQuoteSection() {
    ShareQuoteSection(
        painter = painterResource(R.drawable.evening_mountain_view),
        quote = "Keep shining; you're making remarkable progress!",
        onShareClick = {}
    )
}

@Composable
fun ShareQuoteSection(
    painter: Painter,
    quote: String,
    onShareClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .border(4.dp, Color.White, shape = RoundedCornerShape(20.dp))
    ) {
        Image(
            painter = painter,
            contentDescription = quote,
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.4f)),
                        startY = 0f
                    )
                )
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = LocalSpacing.current.large,
                    horizontal = LocalSpacing.current.extraLarge
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = quote,
                fontFamily = Fraunces,
                style = HeadingMedium,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(LocalSpacing.current.medium))

            ActionButton(
                text = stringResource(R.string.share_title),
                painter = painterResource(R.drawable.ic_share),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Black20.copy(alpha = 0.1f)
                ),
                onClick = onShareClick,
            )
        }
    }
}