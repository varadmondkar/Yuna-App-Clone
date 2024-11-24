package com.varad.yunaappclone.ui.pieChart

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.scale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun PreviewPieChart(modifier: Modifier = Modifier) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
}


@Composable
fun PieChart(
    dataPoints: List<PieChartData>,
    innerRadius: Float = 120f,
    innerCircleColor: Color = Color.White
) {
    var pieCenter by remember {
        mutableStateOf(Offset.Zero)
    }

    val inputList by remember {
        mutableStateOf(dataPoints)
    }

    val gapDegrees = 8f
    val numberOfGaps = dataPoints.size
    val remainingDegrees = 360f - (gapDegrees * numberOfGaps)

    val totalValue = dataPoints.sumOf {
        it.value
    }

    val anglePerValue = remainingDegrees / totalValue

    Canvas(
        modifier = Modifier
            .size(200.dp)
    ) {
        val width = size.width
        val height = size.height

        val radius = width / 2

        pieCenter = Offset(x = width / 2f, y = height / 2f)

        var currentStartAngle = 170f

        inputList.forEach { pieChartInput ->
            val scale = 0.75f
            val angleToDraw = pieChartInput.value * anglePerValue

            scale(scale) {
                drawArc(
                    color = pieChartInput.color,
                    startAngle = currentStartAngle,
                    sweepAngle = angleToDraw,
                    useCenter = true,
                    size = Size(
                        width = radius * 2f,
                        height = radius * 2f
                    ),
                    topLeft = Offset(
                        (width - radius * 2f) / 2f,
                        (height - radius * 2f) / 2f
                    ),
                )
                currentStartAngle += angleToDraw + gapDegrees
            }

            // Inner circle at the center of pie
            drawCircle(
                center = pieCenter,
                color = innerCircleColor,
                radius = innerRadius
            )
        }

    }
}