package com.varad.yunaappclone.ui.summary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.components.ActionButton
import com.varad.yunaappclone.core.components.SolidActionButton

@Preview
@Composable
fun ShowHorizontalButtonsSection() {
    HorizontalButtonsSection(
        {}, {}
    )
}

@Composable
fun HorizontalButtonsSection(
    onPastSummariesClick: () -> Unit,
    onContinueClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ActionButton(
            text = stringResource(R.string.past_summaries_title),
            onClick = onPastSummariesClick,
            painter = painterResource(R.drawable.ic_calendar),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
        )
        SolidActionButton(
            text = stringResource(R.string.continue_session_title),
            onClick = onContinueClick,
            painter = painterResource(R.drawable.ic_book)
        )
    }
}