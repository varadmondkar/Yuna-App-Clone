package com.varad.yunaappclone.domain.userCase

import com.varad.yunaappclone.R
import com.varad.yunaappclone.domain.model.PastSummaryData

class GetPastSummaryData(
    private val getSummaryScreenData: GetSummaryScreenData
) {

    suspend operator fun invoke(summaryId: String = ""): PastSummaryData? {
        val response = getSummaryScreenData.invoke()

        if (response.pastSummaries.isEmpty()) return null

        val pastSummaries = if (summaryId.isBlank())
            response.pastSummaries.first()
        else
            response.pastSummaries.find { it.id == summaryId }

        return pastSummaries?.let {
            PastSummaryData(
                title = response.title,
                id = it.id,
                createdAt = it.createdAt,
                quote = it.quote,
                emotions = it.emotions,
                pieChartData = it.pieChartData,
                highlights = it.highlights,
                summaries = response.pastSummaries,
                // Assuming background Image will come from BE
                // For now hardcoding backgroundImage res for our dummy summary data
                backgroundImage = if (it.id == "unique-summary-id-1")
                    R.drawable.evening_mountain_view
                else
                    R.drawable.green_mountain_view
            )
        }
    }
}