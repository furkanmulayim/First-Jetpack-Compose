package com.furkanmulayim.golden.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.furkanmulayim.golden.R

// Özel Font Ailesi
val inter = FontFamily(
    Font(R.font.inter_w200, FontWeight.W200),
    Font(R.font.inter_w300, FontWeight.W300),
    Font(R.font.inter_w400, FontWeight.W400),
    Font(R.font.inter_w500, FontWeight.W500),
    Font(R.font.inter_w600, FontWeight.W600),
    Font(R.font.inter_w700, FontWeight.W700),
    Font(R.font.inter_w800, FontWeight.W800),
    Font(R.font.inter_w900, FontWeight.W900),
)

object CustomTypo {

    val text = Typography(
        displayLarge = TextStyle(
            fontFamily = inter, fontWeight = FontWeight.W700, fontSize = 34.sp, lineHeight = 41.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = inter, fontWeight = FontWeight.W400, fontSize = 20.sp, lineHeight = 24.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = inter, fontWeight = FontWeight.W500, fontSize = 17.sp, lineHeight = 24.sp
        ),
        labelLarge = TextStyle(
            fontFamily = inter, fontWeight = FontWeight.W400, fontSize = 15.sp, lineHeight = 14.sp,
        ),
        labelSmall = TextStyle(
            fontFamily = inter, fontWeight = FontWeight.W400, fontSize = 13.sp, lineHeight = 14.sp,
        ),
    )

//    val text = Typography(
//        displayMedium = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.W700,
//            fontSize = 28.sp,
//            lineHeight = 35.sp
//        ),
//        displaySmall = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.W600,
//            fontSize = 22.sp,
//            lineHeight = 28.sp
//        ),
//        headlineLarge = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.Bold,
//            fontSize = 20.sp,
//            lineHeight = 26.sp
//        ),
//        headlineMedium = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.SemiBold,
//            fontSize = 17.sp,
//            lineHeight = 24.sp
//        ),
//        headlineSmall = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.Medium,
//            fontSize = 15.sp,
//            lineHeight = 22.sp
//        ),
//        bodyLarge = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.W600,
//            fontSize = 17.sp,
//            lineHeight = 24.sp
//        ),
//        bodyMedium = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.Medium,
//            fontSize = 16.sp,
//            lineHeight = 22.sp
//        ),
//        //BUTTONS
//        bodySmall = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.Medium,
//            fontSize = 15.sp,
//            lineHeight = 20.sp
//        ),
//        labelLarge = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.SemiBold,
//            fontSize = 13.sp,
//            lineHeight = 18.sp
//        ),
//        labelMedium = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.Medium,
//            fontSize = 12.sp,
//            lineHeight = 16.sp
//        ),
//        labelSmall = TextStyle(
//            fontFamily = inter,
//            fontWeight = FontWeight.Medium,
//            fontSize = 11.sp,
//            lineHeight = 14.sp
//        )
//    )
}