package com.varad.yunaappclone.ui.summary

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.varad.yunaappclone.domain.model.SummaryScreenUiModel
import com.varad.yunaappclone.domain.userCase.GetSummaryScreenData
import kotlinx.coroutines.launch

class SummaryViewModel(
    private val getSummaryScreenData: GetSummaryScreenData
): ViewModel() {

    var screenData by mutableStateOf<SummaryScreenUiModel?>(null)
        private set

    fun getSummaryScreenData() {
        viewModelScope.launch {
            screenData = getSummaryScreenData.invoke()
        }
    }
}