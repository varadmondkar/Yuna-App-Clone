package com.varad.yunaappclone.ui.summary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.util.UiEvent
import com.varad.yunaappclone.core.util.UiText
import com.varad.yunaappclone.domain.model.PastSummaryData
import com.varad.yunaappclone.domain.model.SummaryUiModel
import com.varad.yunaappclone.domain.userCase.GetPastSummaryData
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class SummaryViewModel(
    private val getPastSummaryData: GetPastSummaryData
) : ViewModel() {

    var screenData by mutableStateOf<PastSummaryData?>(null)
        private set

    var summaries by mutableStateOf<List<SummaryUiModel>>(listOf())
        private set

    private var _backgroundImage = MutableStateFlow(R.drawable.evening_mountain_view)
    val backgroundImage = _backgroundImage

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun getPastSummaryData() {
        viewModelScope.launch {
            val response = getPastSummaryData.invoke()
            response?.let {
                summaries = it.summaries
                screenData = response
            }
        }
    }

    private fun getSpecificPastSummaryData(summaryId: String) {
        viewModelScope.launch {
            screenData = getPastSummaryData.invoke(summaryId = summaryId)
            screenData?.let {
                _backgroundImage.value = it.backgroundImage
            }
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

    fun onPastSummariesClick(summaryId: String) {
        viewModelScope.launch {
            getSpecificPastSummaryData(summaryId = summaryId)
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