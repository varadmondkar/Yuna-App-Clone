package com.varad.yunaappclone.ui.summary.highlights

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.core.components.ComponentTitle
import com.varad.yunaappclone.domain.model.HighlightUiModel
import com.varad.yunaappclone.ui.theme.Black20
import com.varad.yunaappclone.ui.theme.Fraunces
import com.varad.yunaappclone.ui.theme.HeadingLarge
import com.varad.yunaappclone.ui.theme.Stara
import com.varad.yunaappclone.ui.theme.TitleDefault

@Preview
@Composable
fun ShowHighlightsSection() {
    HighlightsSection(
        listOf(
            HighlightUiModel("Maybe I could try to organize my tasks better and take some time off to relax."),
            HighlightUiModel("I think I’ll start by making a list of all the tasks I need to do and then prioritize them. I also want to set aside some time each day for relaxation."),
            HighlightUiModel("Yes, I think I might need to do that. Thank you for your support."),
        )
    ) {

    }
}

@Composable
fun HighlightsSection(
    highlights: List<HighlightUiModel>,
    onInfoIconClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(20.dp))
            .padding(
                vertical = LocalSpacing.current.medium,
                horizontal = LocalSpacing.current.extraSmall
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(LocalSpacing.current.medium),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                ComponentTitle(
                    mainText = stringResource(R.string.your_label),
                    highlightedText = stringResource(R.string.highlights_label),
                    onInfoClick = onInfoIconClick
                )

                Text(
                    text = stringResource(R.string.during_session_title),
                    style = HeadingLarge,
                    fontFamily = Fraunces,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(LocalSpacing.current.medium))

                Text(
                    text = stringResource(R.string.highlights_component_sub_title),
                    style = TitleDefault,
                    fontFamily = Stara,
                    textAlign = TextAlign.Center,
                    color = Black20.copy(alpha = 0.7f)
                )
            }

            Spacer(modifier = Modifier.height(LocalSpacing.current.medium))

            LazyColumn {
                items(highlights) { highlight ->
                    HighlightCard(highlight = highlight)
                }
            }
        }
    }
}