package com.furkanmulayim.golden.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.furkanmulayim.golden.R

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

object CustomTypo {

    val miniLight = TextStyle(
        fontFamily = helveticaNeue,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
    )

    val miniBold = TextStyle(
        fontFamily = helveticaNeue, fontWeight = FontWeight.Bold, fontSize = 11.sp
    )

    val text = Typography(
        displayLarge = TextStyle(
            fontFamily = helveticaNeue, fontWeight = FontWeight.Bold, fontSize = 45.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = helveticaNeue, fontWeight = FontWeight.Bold, fontSize = 15.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = helveticaNeue, fontWeight = FontWeight.Medium, fontSize = 19.sp
        ),

        bodyMedium = TextStyle(
            fontFamily = helveticaNeue, fontWeight = FontWeight.Medium, fontSize = 16.sp
        ),

        bodySmall = TextStyle(
            fontFamily = helveticaNeue, fontWeight = FontWeight.Bold, fontSize = 15.sp
        ),
        labelLarge = TextStyle(
            fontFamily = helveticaNeue, fontWeight = FontWeight.SemiBold, fontSize = 13.sp
        ),
        labelMedium = TextStyle(
            fontFamily = helveticaNeue, fontWeight = FontWeight.Medium, fontSize = 13.sp
        )
    )
}