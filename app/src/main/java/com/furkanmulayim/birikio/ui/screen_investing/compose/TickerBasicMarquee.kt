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
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.core.state.GoldUiState
import com.furkanmulayim.birikio.model.AllMoneys
import com.furkanmulayim.birikio.ui.theme.AppSize
import com.furkanmulayim.birikio.ui.theme.Typo


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TickerBasicMarquee(goldState: GoldUiState<AllMoneys>) {

    when (goldState) {
        is GoldUiState.Loading -> {
            //CircularProgressIndicator()
        }

        is GoldUiState.Success -> {
            goldState.data
            listOf(
                "", "", ""
            )



            Text(
                text = "text",
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


