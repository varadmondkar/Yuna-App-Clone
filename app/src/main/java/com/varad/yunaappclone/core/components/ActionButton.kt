package com.varad.yunaappclone.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.core.pxToDp
import com.varad.yunaappclone.ui.theme.Label1

@Preview
@Composable
fun ShowActionButton() {
//    SolidActionButton(
//        stringResource(R.string.continue_session_title),
//        {},
//        painter = painterResource(R.drawable.ic_book)
//    )
//    ActionButton(
//        stringResource(R.string.past_summaries_title),
//        {},
//        painter = painterResource(R.drawable.ic_calendar)
//    )
    ActionButton(
        stringResource(R.string.share_title),
        {},
        painter = painterResource(R.drawable.ic_calendar),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent.copy(alpha = 0.8f)
        )
    )
}

@Composable
fun ActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    textStyle: TextStyle = Label1,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    textColor: Color = Color.White,
    painter: Painter?
) {
    Button(
        onClick = onClick,
        enabled = isEnable,
        modifier = modifier,
        shape = RoundedCornerShape(70.pxToDp()),
        border = BorderStroke(0.5.dp, Color.White),
        colors = colors,
    ) {
        painter?.let {
            Image(
                painter = it,
                contentDescription = text,
                modifier = Modifier.size(16.dp)
            )
        }

        Text(
            text = text.toUpperCase(Locale.current),
            style = textStyle,
            color = textColor,
            modifier = Modifier.padding(LocalSpacing.current.small),
            maxLines = 1,
        )
    }
}


@Composable
fun SolidActionButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    textStyle: TextStyle = Label1,
    painter: Painter?
) {
    ActionButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        isEnable = isEnable,
        textStyle = textStyle,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        textColor = Color.Black,
        painter = painter
    )
}