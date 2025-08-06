package com.furkanmulayim.birikio.design.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.furkanmulayim.birikio.R

// Özel Font Ailesi
val helveticaNeue = FontFamily(
    Font(R.font.h1, FontWeight.W900),
    Font(R.font.h2, FontWeight.W800),
    Font(R.font.h3, FontWeight.W700),
    Font(R.font.h4, FontWeight.W600),
    Font(R.font.h5, FontWeight.W500),
    Font(R.font.h6, FontWeight.W400),
    Font(R.font.h7, FontWeight.W300),
    Font(R.font.h8, FontWeight.W200),
)

object Typo {

    val font_43_w800 = TextStyle(
        fontFamily = helveticaNeue,
        fontWeight = FontWeight.W800,
        fontSize = 43.sp,
    )

    val font_19_w800 = TextStyle(
        fontFamily = helveticaNeue,
        fontWeight = FontWeight.W800,
        fontSize = 19.sp,
    )

    val font_16_w500 = TextStyle(
        fontFamily = helveticaNeue,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
    )
    val font_12_w500 = TextStyle(
        fontFamily = helveticaNeue,
        fontWeight = FontWeight.W500,
        fontSize = 12.sp,
    )
}