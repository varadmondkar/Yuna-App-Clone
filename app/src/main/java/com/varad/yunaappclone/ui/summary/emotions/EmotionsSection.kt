package com.varad.yunaappclone.ui.summary.emotions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.core.components.ComponentTitle
import com.varad.yunaappclone.ui.pieChart.PieChart
import com.varad.yunaappclone.ui.pieChart.PieChartData
import com.varad.yunaappclone.ui.theme.Fraunces
import com.varad.yunaappclone.ui.theme.HeadingLarge


@Preview
@Composable
fun ShowEmotionsSection() {
    EmotionsSection(
        listOf(
            Emotion("Joy", "50%"),
            Emotion("Trust", "25%"),
            Emotion("Surprise", "15%"),
            Emotion("Fear", "15%"),
            Emotion("Sadness", "10%"),
        )
    ) {

    }
}

@Composable
fun EmotionsSection(
    emotions: List<Emotion>,
    onInfoIconClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(20.dp))
            .padding(
                vertical = LocalSpacing.current.medium,
                horizontal = LocalSpacing.current.extraSmall
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LocalSpacing.current.medium),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ComponentTitle(
                    mainText = stringResource(R.string.your_main_label),
                    highlightedText = stringResource(R.string.emotions_label),
                    onInfoClick = onInfoIconClick
                )

                Text(
                    text = stringResource(R.string.during_session_title),
                    style = HeadingLarge,
                    fontFamily = Fraunces,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(LocalSpacing.current.medium))

                // Pie Chart here
                PieChart(
                    dataPoints = listOf(
                        PieChartData(
                            value = 50,
                            label = "Joy"
                        ),
                        PieChartData(
                            value = 25,
                            label = "Trust"
                        ),
                        PieChartData(
                            value = 15,
                            label = "Surprise"
                        ),
                        PieChartData(
                            value = 15,
                            label = "Fear"
                        ),
                        PieChartData(
                            value = 10,
                            label = "Sadness"
                        ),
                    ),
                    innerCircleColor = Color.White
                )
            }

            Spacer(modifier = Modifier.height(LocalSpacing.current.medium))

            LazyColumn {
                items(emotions) { emotion ->
                    EmotionCard(emotion = emotion)
                }
            }
        }
    }
}