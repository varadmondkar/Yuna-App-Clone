package com.varad.yunaappclone.data.mapper

import com.varad.yunaappclone.data.local.entity.ConversationResponse
import com.varad.yunaappclone.domain.model.EmotionUiModel
import com.varad.yunaappclone.domain.model.HighlightUiModel
import com.varad.yunaappclone.domain.model.SummaryScreenUiModel
import com.varad.yunaappclone.domain.model.SummaryUiModel

fun ConversationResponse.toSummaryScreenUiModel(): SummaryScreenUiModel {

    return SummaryScreenUiModel(
        title = conversation.title,
        pastSummaries = conversation.pastSummaries.map {

            SummaryUiModel(
                id = it.id,
                createdAt = it.createdAt,
                quote = it.quote,
                emotions = it.emotions.map { emotion ->
                    EmotionUiModel(
                        text = emotion.name,
                        percent = "${emotion.value.toInt()}%"
                    )
                },
                pieChartData = null,
                highlights = it.highlights.map { highlight ->
                    HighlightUiModel(text = highlight)
                }
            )
        }
    )
}