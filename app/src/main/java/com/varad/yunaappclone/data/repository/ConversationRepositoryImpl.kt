package com.varad.yunaappclone.data.repository

import com.google.gson.Gson
import com.varad.yunaappclone.data.local.entity.ConversationResponse
import com.varad.yunaappclone.domain.repository.ConversationRepository

class ConversationRepositoryImpl : ConversationRepository {

    override suspend fun getConversationDetails(): ConversationResponse {
        val response =
            "{\"conversation\":{\"id\":\"unique-conversation-id\",\"title\":\"Addressing Personal Concerns in Therapy\",\"createdAt\":\"2024-11-18T12:00:00Z\",\"updatedAt\":\"2024-11-18T14:00:00Z\",\"pastSummaries\":[{\"id\":\"unique-summary-id-1\",\"createdAt\":\"2024-11-18T12:15:00Z\",\"quote\":\"Keep shining; you're making remarkable progress.\",\"emotions\":[{\"name\":\"Joy\",\"value\":50.0},{\"name\":\"Trust\",\"value\":25.0},{\"name\":\"Surprise\",\"value\":15.0},{\"name\":\"Fear\",\"value\":15.0},{\"name\":\"Sadness\",\"value\":10.0}],\"highlights\":[\"Maybe I could try to organize my tasks better and take some time off to relax.\",\"I think I'll start by making a list of all the tasks I need to do and then prioritize them.\",\"Yes, I think I might need to do that. Thank you for your support.\"]},{\"id\":\"unique-summary-id-2\",\"createdAt\":\"2024-11-18T13:00:00Z\",\"quote\":\"Progress is a journey, not a destination.\",\"emotions\":[{\"name\":\"Hope\",\"value\":40.0},{\"name\":\"Gratitude\",\"value\":30.0},{\"name\":\"Calmness\",\"value\":30.0}],\"highlights\":[\"I’m learning to appreciate small wins every day.\",\"Taking things one step at a time really helps.\"]}]}}"
        val conversationResponse = Gson().fromJson(response, ConversationResponse::class.java)
        return conversationResponse
    }
}