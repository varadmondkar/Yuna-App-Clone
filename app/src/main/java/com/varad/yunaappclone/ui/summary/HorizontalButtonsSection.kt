package com.varad.yunaappclone.ui.summary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
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
    ) {
        ActionButton(
            text = stringResource(R.string.past_summaries_title),
            painter = painterResource(R.drawable.ic_calendar),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black.copy(alpha = 0.1f)
            ),
            textSize = 9.sp,
            modifier = Modifier.weight(1f),
            onClick = onPastSummariesClick,
        )
        Spacer(modifier = Modifier.width(LocalSpacing.current.extraSmall))
        SolidActionButton(
            text = stringResource(R.string.continue_session_title),
            painter = painterResource(R.drawable.ic_book),
            textSize = 9.sp,
            modifier = Modifier.weight(1f),
            onClick = onContinueClick
        )
    }
}