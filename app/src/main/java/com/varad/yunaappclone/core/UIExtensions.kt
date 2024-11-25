package com.varad.yunaappclone.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.varad.yunaappclone.ui.theme.emotion1
import com.varad.yunaappclone.ui.theme.emotion2
import com.varad.yunaappclone.ui.theme.emotion3
import com.varad.yunaappclone.ui.theme.emotion4
import com.varad.yunaappclone.ui.theme.emotion5


@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }

@Composable
fun Dp.dpToPx() = with(LocalDensity.current) { this@dpToPx.toPx() }


fun String.hexToColor(): Color {
    return try {
        val cleanHex = this.removePrefix("#")

        val colorInt = when (cleanHex.length) {
            6 -> cleanHex.toLong(16) or 0xFF000000
            8 -> cleanHex.toLong(16)
            else -> throw IllegalArgumentException("Invalid HEX color format")
        }

        Color(colorInt.toInt())
    } catch (e: Exception) {
        throw IllegalArgumentException("Invalid HEX color: $this")
    }
}

fun Int.getUniqueColor(): Color {
    val colors = listOf(
        emotion1,
        emotion2,
        emotion3,
        emotion4,
        emotion5
    )
    val boundedIndex = this % colors.size
    return colors[boundedIndex]
}