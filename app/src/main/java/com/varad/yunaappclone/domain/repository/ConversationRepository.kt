package com.varad.yunaappclone.domain.repository

import com.varad.yunaappclone.data.local.entity.ConversationResponse

interface ConversationRepository {

    suspend fun getConversationDetails(): ConversationResponse
}