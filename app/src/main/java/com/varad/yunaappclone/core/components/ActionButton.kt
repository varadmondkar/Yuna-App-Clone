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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.core.pxToDp
import com.varad.yunaappclone.ui.theme.Label1
import com.varad.yunaappclone.ui.theme.Stara

@Preview
@Composable
fun ShowActionButton() {
    ActionButton(
        stringResource(R.string.past_summaries_title),
        painter = painterResource(R.drawable.ic_calendar),
        onClick = {}
    )
}

@Composable
fun ActionButton(
    text: String,
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    textStyle: TextStyle = Label1,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    textColor: Color = Color.White,
    textSize: TextUnit = 12.sp,
    textFont: FontFamily = Stara,
    painter: Painter?,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        enabled = isEnable,
        modifier = modifier,
        shape = RoundedCornerShape(70.pxToDp()),
        border = BorderStroke(1.dp, Color.White),
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
            fontFamily = textFont,
            color = textColor,
            fontSize = textSize,
            modifier = Modifier.padding(LocalSpacing.current.small),
            maxLines = 1,
        )
    }
}


@Composable
fun SolidActionButton(
    text: String,
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    textStyle: TextStyle = Label1,
    textSize: TextUnit = 12.sp,
    painter: Painter?,
    onClick: () -> Unit
) {
    ActionButton(
        text = text,
        onClick = onClick,
        modifier = modifier,
        isEnable = isEnable,
        textStyle = textStyle,
        textSize = textSize,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        textColor = Color.Black,
        painter = painter
    )
}