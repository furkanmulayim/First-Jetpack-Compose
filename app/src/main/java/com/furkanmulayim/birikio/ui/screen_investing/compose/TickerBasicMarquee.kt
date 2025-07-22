package com.furkanmulayim.birikio.ui.screen_investing.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.MarqueeSpacing
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.core.enums.InvestE
import com.furkanmulayim.birikio.core.extensions.currencyFormat
import com.furkanmulayim.birikio.core.state.GoldUiState
import com.furkanmulayim.birikio.model.AllMoneys
import com.furkanmulayim.birikio.ui.theme.AppSize
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.blued
import com.furkanmulayim.birikio.ui.theme.twins_75


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TickerBasicMarquee(goldState: GoldUiState<AllMoneys>) {

    when (goldState) {
        is GoldUiState.Loading -> {
            //CircularProgressIndicator()
        }

        is GoldUiState.Success -> {
            val data = goldState.data
            val moneyItems = listOf(
                InvestE.DOLLAR.value to data.usd,
                InvestE.EURO.value to data.eur,
                InvestE.GRAM24.value to data.grams24,
                InvestE.GRAM22.value to data.grams22,
                InvestE.CEYREK.value to data.quart,
                InvestE.YARIM.value to data.half,
                InvestE.TAM.value to data.full,
                InvestE.RESAT.value to data.resat
            )

            val text = buildAnnotatedString {
                moneyItems.forEachIndexed { index, (name, value) ->
                    append("$name ")
                    withStyle(style = SpanStyle(color = blued)) {
                        append(value.toString().currencyFormat())
                    }
                    withStyle(style = SpanStyle(color = twins_75)) {
                        append("   |   ")
                    }
                }
            }

            Text(
                text = text,
                modifier = Modifier
                    .background(colorScheme.secondary)
                    .padding(vertical = AppSize.PaddingSmall)
                    .fillMaxWidth()
                    .basicMarquee(
                        iterations = Int.MAX_VALUE,
                        spacing = MarqueeSpacing.fractionOfContainer(0f),
                        velocity = 75.dp
                    ),
                style = Typo.font_16_w500.copy(colorScheme.scrim)
            )
        }

        is GoldUiState.Error -> {
            val message = goldState.message
            Text("Unexpected Fail: $message")
        }
    }
}


