package com.varad.yunaappclone.ui.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.core.util.UiEvent
import com.varad.yunaappclone.data.repository.ConversationRepositoryImpl
import com.varad.yunaappclone.domain.userCase.GetPastSummaryData
import com.varad.yunaappclone.domain.userCase.GetSummaryScreenData
import com.varad.yunaappclone.ui.summary.emotions.EmotionsSection
import com.varad.yunaappclone.ui.summary.highlights.HighlightsSection
import com.varad.yunaappclone.ui.theme.BodyDefault
import com.varad.yunaappclone.ui.theme.White30

@Composable
fun SummaryScreen(
    viewModel: SummaryViewModel,
    contentModifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    onNavigate: (UiEvent.Navigate) -> Unit,
    onNavigateUp: () -> Unit
) {
    val context = LocalContext.current
    val localSpacing = LocalSpacing.current

    val screenData = viewModel.screenData
    val summaries = viewModel.summaries

    var showPastSummariesDialog by remember { mutableStateOf(false) }
    val backgroundImage by viewModel.backgroundImage.collectAsState()

    val statusBarHeight = with(LocalDensity.current) {
        WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    }

    LaunchedEffect(true) {
        viewModel.getPastSummaryData()
    }

    LaunchedEffect(true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> onNavigate(event)
                is UiEvent.NavigateUp -> onNavigateUp()
                is UiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(
                        message = event.message.asString(context),
                        duration = SnackbarDuration.Short
                    )
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        if (showPastSummariesDialog) {
            Popup(
                alignment = Alignment.Center,
                onDismissRequest = { showPastSummariesDialog = false },
                properties = PopupProperties(focusable = true)
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(localSpacing.medium)
                        .width(200.dp)
                ) {
                    summaries.forEach { item ->
                        Text(
                            text = item.id,
                            style = BodyDefault,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    viewModel.onPastSummariesClick(summaryId = item.id)
                                    showPastSummariesDialog = false
                                }
                                .padding(8.dp)
                        )
                    }
                }
            }
        }

        screenData?.let { data ->
            // Background Image and Gradient
            Image(
                painter = painterResource(backgroundImage),
                contentDescription = "Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(Color.Transparent, White30, White30),
                            startY = 700f
                        )
                    )
            )

            // Vertical scrolling components
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
            ) {

                item(key = "TopNavigationBar") {
                    Spacer(modifier = Modifier.height(statusBarHeight + 20.dp))
                    TopNavigationSection(
                        viewModel::onBackClick,
                        viewModel::onChatClick,
                        viewModel::onMoreOptionsClick,
                    )
                }

                item(key = "ScreenTitleSection") {
                    Spacer(modifier = Modifier.height(localSpacing.extraLarge))
                    ScreenTitleSection(data.title)
                }

                item(key = "HorizontalButtonsSection") {
                    Spacer(modifier = Modifier.height(localSpacing.medium))
                    HorizontalButtonsSection(
                        onPastSummariesClick = {
                            showPastSummariesDialog = true
                        },
                        onContinueClick = viewModel::onContinueClick
                    )
                }

                item(key = "ShareQuoteSection") {
                    Spacer(modifier = Modifier.height(localSpacing.medium))
                    ShareQuoteSection(
                        painter = painterResource(backgroundImage),
                        quote = screenData.quote,
                        onShareClick = viewModel::onShareClick
                    )
                }

                item(key = "EmotionsSection") {
                    Spacer(modifier = Modifier.height(localSpacing.medium))
                    EmotionsSection(
                        emotions = screenData.emotions,
                        pieChartData = screenData.pieChartData,
                        onEmotionInfoClick = viewModel::onEmotionInfoClick
                    )
                }
                item(key = "HighlightsSection") {
                    Spacer(modifier = Modifier.height(localSpacing.medium))
                    HighlightsSection(
                        highlights = screenData.highlights,
                        onHighlightsInfoClick = viewModel::onHighlightsInfoClick
                    )
                }
                item(key = "PageButton") {
                    Spacer(modifier = Modifier.height(localSpacing.medium))
                    ScreenButtonSection(viewModel::onScreenButtonClick)
                    Spacer(modifier = Modifier.height(localSpacing.large))
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowSummaryScreen() {
    SummaryScreen(
        viewModel = SummaryViewModel(
            getPastSummaryData = GetPastSummaryData(
                GetSummaryScreenData(ConversationRepositoryImpl())
            )
        ),
        snackbarHostState = remember { SnackbarHostState() },
        onNavigate = {}
    ) { }
}