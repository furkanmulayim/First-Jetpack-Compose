package com.furkanmulayim.birikio.feature.screen_home.ui.component

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
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.state.GoldUiState
import com.furkanmulayim.birikio.design.theme.Typo
import com.furkanmulayim.birikio.feature.screen_home.data.model.AllMoneys
import com.furkanmulayim.birikio.feature.screen_home.data.model.RateCurrency


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MarqueeText(goldState: GoldUiState<AllMoneys>) {

    listOf(
        RateCurrency(
            name = "Dolar", icon = R.drawable.money_dollar, code = "USD", price = "42,35"
        ), RateCurrency(
            name = "Euro", icon = R.drawable.money_euro, code = "EUR", price = "45,35"
        ), RateCurrency(
            name = "Gram", icon = R.drawable.money_gram, code = "GR", price = "4.535"
        )
    )

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
                    .padding(vertical = 12.dp)
                    .fillMaxWidth()
                    .basicMarquee(
                        iterations = Int.MAX_VALUE,
                        spacing = MarqueeSpacing.fractionOfContainer(0f),
                        velocity = 75.dp
                    ),
                style = Typo.font_16_w500,
                color = colorScheme.scrim

            )
        }

        is GoldUiState.Error -> {
            val message = goldState.message
            Text("Unexpected Fail: $message")
        }
    }
}


