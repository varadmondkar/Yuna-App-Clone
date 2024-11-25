package com.varad.yunaappclone.data.local.entity

data class ConversationResponse(
    val conversation: Conversation,
)

data class Conversation(
    val id: String,
    val title: String,
    val createdAt: String,
    val updatedAt: String,
    val pastSummaries: List<Summary>,
)

data class Summary(
    val id: String,
    val createdAt: String,
    val quote: String,
    val emotions: List<Emotion>,
    val highlights: List<String>,
)

data class Emotion(
    val name: String,
    val value: Double,
)
