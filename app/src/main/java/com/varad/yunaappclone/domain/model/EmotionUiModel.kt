package com.varad.yunaappclone.domain.model

import androidx.compose.ui.graphics.Color

data class EmotionUiModel(
    val text: String,
    val percent: Int,
    val percentText: String,
    val color: Color,
)
