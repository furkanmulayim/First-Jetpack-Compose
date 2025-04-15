package com.furkanmulayim.golden.presentation.tab_pages.investing_ui.widget

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.Typo


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TickerBasicMarquee() {
    val text = buildAnnotatedString {
        append("USD ")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onTertiary)) {
            append("38.76₺")
        }
        append("  |  EUR ")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.inverseSurface)) {
            append("43.29₺")
        }
        append("  |  Ons Altın ")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onTertiary)) {
            append("112.800$")
        }
        append("  |  Gram Altın ₂₂ ")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.inverseSurface)) {
            append("3.712₺")
        }
        append("  |  Gram Altın ₂₄ ")
        withStyle(style = SpanStyle(color = MaterialTheme.colorScheme.onTertiary)) {
            append("3.912₺")
        }
        append("  | ")
    }
    Text(
        text = text,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .padding(vertical = AppSize.PaddingSmall)
            .fillMaxWidth()
            .basicMarquee(
                iterations = Int.MAX_VALUE,
                spacing = MarqueeSpacing.fractionOfContainer(0f),
                velocity = 35.dp
            ),
        style = Typo.font_16_w500.copy(MaterialTheme.colorScheme.scrim)
    )
}


