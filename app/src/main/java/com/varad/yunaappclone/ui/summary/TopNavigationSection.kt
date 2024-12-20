package com.varad.yunaappclone.ui.summary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.varad.yunaappclone.R
import com.varad.yunaappclone.core.LocalSpacing
import com.varad.yunaappclone.core.components.IconButton

@Preview
@Composable
fun ShowTopNavigationSection() {
    TopNavigationSection(
        {}, {}, {}
    )
}

@Composable
fun TopNavigationSection(
    onBackClick: () -> Unit,
    onChatClick: () -> Unit,
    onMoreOptionsClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            painter = painterResource(R.drawable.ic_back),
            onClick = onBackClick,
            imageDescription = stringResource(R.string.back_image_desc)
        )

        Row {
            IconButton(
                painter = painterResource(R.drawable.ic_messages),
                onClick = onChatClick,
                imageDescription = stringResource(R.string.more_option_image_desc)
            )

            Spacer(modifier = Modifier.width(LocalSpacing.current.small))

            IconButton(
                painter = painterResource(R.drawable.ic_three_dots),
                onClick = onMoreOptionsClick,
                imageDescription = stringResource(R.string.more_option_image_desc)
            )
        }
    }
}