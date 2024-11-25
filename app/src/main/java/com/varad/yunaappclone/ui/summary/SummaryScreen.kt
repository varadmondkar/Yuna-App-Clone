package com.varad.yunaappclone.ui.summary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.core.util.UiEvent
import com.varad.yunaappclone.data.repository.ConversationRepositoryImpl
import com.varad.yunaappclone.domain.userCase.GetSummaryScreenData
import com.varad.yunaappclone.ui.summary.emotions.EmotionsSection
import com.varad.yunaappclone.ui.summary.highlights.HighlightsSection
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

    val statusBarHeight = with(LocalDensity.current) {
        WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    }

    LaunchedEffect(true) {
        viewModel.getSummaryScreenData()
    }

    LaunchedEffect(key1 = true) {
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

        // Background Image and Gradient
        Image(
            painter = painterResource(R.drawable.evening_mountain_view),
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
        screenData?.let { data ->
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
                        onPastSummariesClick = viewModel::onPastSummariesClick,
                        onContinueClick = viewModel::onContinueClick
                    )
                }

                item(key = "ShareQuoteSection") {
                    Spacer(modifier = Modifier.height(localSpacing.medium))
                    ShareQuoteSection(
                        painter = painterResource(R.drawable.evening_mountain_view),
                        quote = screenData.pastSummaries[0].quote,
                        onShareClick = viewModel::onShareClick
                    )
                }

                item(key = "EmotionsSection") {
                    Spacer(modifier = Modifier.height(localSpacing.medium))
                    EmotionsSection(
                        emotions = screenData.pastSummaries[0].emotions,
                        pieChartData = screenData.pastSummaries[0].pieChartData,
                        onEmotionInfoClick = viewModel::onEmotionInfoClick
                    )
                }
                item(key = "HighlightsSection") {
                    Spacer(modifier = Modifier.height(localSpacing.medium))
                    HighlightsSection(
                        highlights = screenData.pastSummaries[0].highlights,
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
        viewModel = SummaryViewModel(GetSummaryScreenData(ConversationRepositoryImpl())),
        snackbarHostState = remember { SnackbarHostState() },
        onNavigate = {}
    ) { }
}