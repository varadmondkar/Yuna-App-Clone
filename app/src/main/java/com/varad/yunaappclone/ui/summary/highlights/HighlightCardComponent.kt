package com.varad.yunaappclone.ui.summary.highlights

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.domain.model.HighlightUiModel
import com.varad.yunaappclone.ui.theme.Black20
import com.varad.yunaappclone.ui.theme.BodyDefault
import com.varad.yunaappclone.ui.theme.Stara
import com.varad.yunaappclone.ui.theme.White20

@Preview
@Composable
fun ShowHighlightCard() {
    HighlightCard(HighlightUiModel("Maybe I could try to organize my tasks better and take some time off to relax."))
}

@Composable
fun HighlightCard(
    highlight: HighlightUiModel,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(LocalSpacing.current.extraSmall),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            contentColor = White20
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(LocalSpacing.current.small),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.ic_quotation),
                contentDescription = highlight.text
            )

            Text(
                text = highlight.text,
                style = BodyDefault,
                textAlign = TextAlign.Center,
                fontFamily = Stara,
                color = Black20.copy(alpha = 0.7f)
            )
        }
    }
}