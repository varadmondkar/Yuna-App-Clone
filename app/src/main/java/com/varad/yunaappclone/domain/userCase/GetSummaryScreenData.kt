package com.varad.yunaappclone.domain.userCase

import com.varad.yunaappclone.data.mapper.toSummaryScreenUiModel
import com.varad.yunaappclone.domain.model.SummaryScreenUiModel
import com.varad.yunaappclone.domain.repository.ConversationRepository

class GetSummaryScreenData(
    private val conversationRepository: ConversationRepository
) {

    suspend operator fun invoke(): SummaryScreenUiModel {
        val response = conversationRepository.getConversationDetails()
        return response.toSummaryScreenUiModel()
    }
}