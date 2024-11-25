package com.varad.yunaappclone.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.ui.theme.Fraunces
import com.varad.yunaappclone.ui.theme.Green30
import com.varad.yunaappclone.ui.theme.HeadingLarge
import com.varad.yunaappclone.ui.theme.HeadingLargeSpan
import com.varad.yunaappclone.ui.theme.HeadingXLargeSpan

@Preview
@Composable
fun ShowComponentTitle() {
    ComponentTitle(
        mainText = stringResource(R.string.your_label),
        highlightedText = stringResource(R.string.highlights_label)
    ) {

    }
}

@Composable
fun ComponentTitle(
    mainText: String,
    highlightedText: String,
    onInfoClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        val annotatedTitle = buildAnnotatedString {
            withStyle(
                style = HeadingLargeSpan
            ) {
                append(mainText)
            }
            append(" ")
            withStyle(
                style = HeadingXLargeSpan.copy(
                    color = Green30
                )
            ) {
                append(highlightedText)
            }
        }
        Text(
            text = annotatedTitle,
            style = HeadingLarge,
            fontFamily = Fraunces,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(LocalSpacing.current.extraSmall))
        Image(
            painter = painterResource(R.drawable.ic_info_green),
            contentDescription = stringResource(R.string.information_icon_image_desc),
            modifier = Modifier.size(24.dp).clickable(onClick = onInfoClick)
        )
    }
}