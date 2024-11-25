package com.varad.yunaappclone.ui.summary.emotions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.varad.yunaappclone.domain.model.EmotionUiModel
import com.varad.yunaappclone.ui.pieChart.PieChart
import com.varad.yunaappclone.ui.pieChart.PieChartData
import com.varad.yunaappclone.ui.theme.Fraunces
import com.varad.yunaappclone.ui.theme.HeadingLarge
import com.varad.yunaappclone.ui.theme.emotion1
import com.varad.yunaappclone.ui.theme.emotion2
import com.varad.yunaappclone.ui.theme.emotion3
import com.varad.yunaappclone.ui.theme.emotion4
import com.varad.yunaappclone.ui.theme.emotion5


@Preview
@Composable
fun ShowEmotionsSection() {
    EmotionsSection(
        emotions = listOf(
            EmotionUiModel("Joy", 50, "50%", emotion1),
            EmotionUiModel("Trust", 25, "25%", emotion2),
            EmotionUiModel("Surprise", 15, "15%", emotion3),
            EmotionUiModel("Fear", 15, "15%", emotion4),
            EmotionUiModel("Sadness", 10, "10%", emotion5),
        ),
        pieChartData = listOf(
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
        onEmotionInfoClick = {  }
    )
}

@Composable
fun EmotionsSection(
    emotions: List<EmotionUiModel>,
    pieChartData: List<PieChartData>?,
    onEmotionInfoClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White, shape = RoundedCornerShape(20.dp))
            .padding(
                vertical = LocalSpacing.current.medium,
                horizontal = LocalSpacing.current.extraSmall
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
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
                    onInfoClick = onEmotionInfoClick
                )

                Text(
                    text = stringResource(R.string.during_session_title),
                    style = HeadingLarge,
                    fontFamily = Fraunces,
                    textAlign = TextAlign.Center
                )

                pieChartData?.let {
                    Spacer(modifier = Modifier.height(LocalSpacing.current.medium))
                    PieChart(
                        dataPoints = pieChartData,
                        innerCircleColor = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(LocalSpacing.current.small))

            emotions.forEach {
                EmotionCard(emotion = it)
            }
        }
    }
}