package com.varad.yunaappclone.ui.summary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.util.UiEvent
import com.varad.yunaappclone.core.util.UiText
import com.varad.yunaappclone.domain.model.SummaryScreenUiModel
import com.varad.yunaappclone.domain.userCase.GetSummaryScreenData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SummaryViewModel(
    private val getSummaryScreenData: GetSummaryScreenData
): ViewModel() {

    var screenData by mutableStateOf<SummaryScreenUiModel?>(null)
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun getSummaryScreenData() {
        viewModelScope.launch {
            screenData = getSummaryScreenData.invoke()
        }
    }

    // We can manage all click events here, for now showing just a SnackBar message on it's click
    fun onBackClick() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.NavigateUp
            )
        }
    }

    fun onChatClick() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.chat_image_desc)
                )
            )
        }
    }

    fun onMoreOptionsClick() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.more_option_image_desc)
                )
            )
        }
    }

    fun onPastSummariesClick() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.past_summaries_title)
                )
            )
        }
    }

    fun onContinueClick() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.continue_session_title)
                )
            )
        }
    }

    fun onShareClick() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.share_title)
                )
            )
        }
    }

    fun onEmotionInfoClick() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.information_icon_image_desc)
                )
            )
        }
    }

    fun onHighlightsInfoClick() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.information_icon_image_desc)
                )
            )
        }
    }

    fun onScreenButtonClick() {
        viewModelScope.launch {
            _uiEvent.send(
                UiEvent.ShowSnackbar(
                    UiText.StringResource(R.string.continue_session_title)
                )
            )
        }
    }
}