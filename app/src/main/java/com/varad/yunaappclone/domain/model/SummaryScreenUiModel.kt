package com.varad.yunaappclone.domain.model

import com.varad.yunaappclone.ui.pieChart.PieChartData

data class SummaryScreenUiModel(
    val title: String,
    val pastSummaries: List<SummaryUiModel>,
)

data class SummaryUiModel(
    val id: String,
    val createdAt: String,
    val quote: String,
    val emotions: List<EmotionUiModel>,
    val pieChartData: List<PieChartData>?,
    val highlights: List<HighlightUiModel>,
)