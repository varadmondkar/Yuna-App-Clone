package com.varad.yunaappclone.ui.theme

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.varad.yunaappclone.R

// Font Family
val Fraunces = FontFamily(
    Font(resId = R.font.fraunces_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.fraunces_bold, weight = FontWeight.Bold),
)

val Stara = FontFamily(
    Font(resId = R.font.stara_medium, weight = FontWeight.Medium),
    Font(resId = R.font.stara_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.stara_bold, weight = FontWeight.Bold),
)

// Custom Typography: These labels can be added to the Figma DSM to ensure consistency throughout the application.
val HeadingXLargeSpan = SpanStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    color = Black20
)

val HeadingLargeSpan = SpanStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    color = Black20
)

val HeadingXLarge = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 32.sp,
    color = Black20
)

val HeadingLarge = TextStyle(
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    lineHeight = 32.sp,
    color = Black20
)

val TitleDefault = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 22.sp,
    color = Black20
)

val BodyDefault = TextStyle(
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    color = Black20
)

val HeadingMedium = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp,
    lineHeight = 30.sp
)

val Label1 = TextStyle(
    fontWeight = FontWeight.Bold,
    fontSize = 12.sp,
    lineHeight = 18.sp
)
