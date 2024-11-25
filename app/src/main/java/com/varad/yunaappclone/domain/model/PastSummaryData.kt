package com.varad.yunaappclone.domain.model

import com.varad.yunaappclone.ui.pieChart.PieChartData

data class PastSummaryData(
    val id: String,
    val createdAt: String,
    val title: String,
    val quote: String,
    val emotions: List<EmotionUiModel>,
    val pieChartData: List<PieChartData>?,
    val highlights: List<HighlightUiModel>,
    val summaries: List<SummaryUiModel>,
    val backgroundImage: Int,
)
