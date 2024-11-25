package com.varad.yunaappclone.core.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.ui.theme.Green40

@Preview
@Composable
fun ShowPrimaryButton() {
    PrimaryButton(
        stringResource(R.string.continue_session_title)
    ) {

    }
}

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    isEnable: Boolean = true,
    textStyle: TextStyle = MaterialTheme.typography.labelMedium,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnable,
        shape = RoundedCornerShape(40.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Green40
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