package com.varad.yunaappclone.core.util

sealed class UiEvent {
    data class Navigate(val route: String): UiEvent()
    data class ShowSnackbar(val message: UiText): UiEvent()
}