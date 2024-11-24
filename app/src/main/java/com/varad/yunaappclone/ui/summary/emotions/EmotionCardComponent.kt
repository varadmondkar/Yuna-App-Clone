package com.varad.yunaappclone.ui.summary.emotions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.domain.model.EmotionUiModel
import com.varad.yunaappclone.ui.theme.Black20
import com.varad.yunaappclone.ui.theme.Stara
import com.varad.yunaappclone.ui.theme.TitleDefault
import com.varad.yunaappclone.ui.theme.White20


@Preview
@Composable
fun ShowEmotionCardComponent() {
    EmotionCard(EmotionUiModel("Joy", "25%"))
}

@Composable
fun EmotionCard(
    emotion: EmotionUiModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(LocalSpacing.current.extraSmall),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            contentColor = White20
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = LocalSpacing.current.small,
                    horizontal = LocalSpacing.current.medium,
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.size(16.dp)
                        .background(Color.Gray, CircleShape)
                )

                Spacer(modifier = Modifier.width(LocalSpacing.current.small))

                Text(
                    text = emotion.text,
                    style = TitleDefault,
                    fontFamily = Stara,
                    color = Black20
                )
            }

            Text(
                text = emotion.percent,
                style = TitleDefault,
                textAlign = TextAlign.Center,
                fontFamily = Stara,
                color = Black20.copy(alpha = 0.5f)
            )
        }
    }
}