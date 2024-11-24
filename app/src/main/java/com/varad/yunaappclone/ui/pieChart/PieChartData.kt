package com.varad.yunaappclone.ui.pieChart

import androidx.compose.ui.graphics.Color

data class PieChartData(
    val color: Color = getRandomColor(),
    val value: Int,
    val label: String
)

internal fun getRandomColor(): Color {
    return Color(
        red = (0..255).random(),
        blue =  (0..255).random(),
        green =  (0..255).random()
    )
}