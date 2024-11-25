package com.varad.yunaappclone.data.mapper

import com.varad.yunaappclone.core.getUniqueColor
import com.varad.yunaappclone.data.local.entity.ConversationResponse
import com.varad.yunaappclone.domain.model.EmotionUiModel
import com.varad.yunaappclone.domain.model.HighlightUiModel
import com.varad.yunaappclone.domain.model.SummaryScreenUiModel
import com.varad.yunaappclone.domain.model.SummaryUiModel
import com.varad.yunaappclone.ui.pieChart.PieChartData

fun ConversationResponse.toSummaryScreenUiModel(): SummaryScreenUiModel {

    return SummaryScreenUiModel(
        title = conversation.title,
        pastSummaries = conversation.pastSummaries.map {
            val emotionList = mutableListOf<EmotionUiModel>()
            val pieChartData = mutableListOf<PieChartData>()
            it.emotions.mapIndexed { index, emotion ->
                val color = index.getUniqueColor()
                emotionList.add(
                    EmotionUiModel(
                        text = emotion.name,
                        percent = emotion.value.toInt(),
                        percentText = "${emotion.value.toInt()}%",
                        color = color
                    )
                )
                pieChartData.add(
                    PieChartData(
                        color = color,
                        value = emotion.value.toInt(),
                        label = emotion.name
                    )
                )
            }

            SummaryUiModel(
                id = it.id,
                createdAt = it.createdAt,
                quote = it.quote,
                emotions = emotionList,
                pieChartData = pieChartData,
                highlights = it.highlights.map { highlight ->
                    HighlightUiModel(text = highlight)
                }
            )
        }
    )
}