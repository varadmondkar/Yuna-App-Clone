package com.varad.yunaappclone.core.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.core.pxToDp
import com.varad.yunaappclone.ui.theme.Green80

@Preview
@Composable
fun ShowPrimaryButton() {
    PrimaryButton(
        "Continue Session",
        {}
    )
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.labelMedium
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnable,
        shape = RoundedCornerShape(40.pxToDp()),
        colors = ButtonDefaults.buttonColors(
            containerColor = Green80
        )
    ) {
        Text(
            text = text.toUpperCase(Locale.current),
            style = textStyle,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(LocalSpacing.current.small)
        )
    }
}