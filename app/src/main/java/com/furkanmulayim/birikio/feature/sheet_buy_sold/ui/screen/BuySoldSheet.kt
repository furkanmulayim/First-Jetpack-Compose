package com.furkanmulayim.birikio.feature.sheet_buy_sold.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.card.GeneralCard
import com.furkanmulayim.birikio.design.component.page.CustomScaffold
import com.furkanmulayim.birikio.design.theme.Appsize

@Composable
fun BuySoldSheet(
    isBuySelected: Boolean,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surfaceVariant)
            .padding(top = Appsize.zero)
    ) {
        CustomScaffold {
            SelectionSection(isBuySelected)
            CardSection()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SelectionSection(isBuySelected: Boolean) {

    val textBuy = stringResource(R.string.textBuy)
    val textSold = stringResource(R.string.textSold)

    var selected by rememberSaveable { mutableStateOf(if (isBuySelected) textBuy else textSold) }
    val items = listOf(textBuy, textSold)

    Row(
        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
    ) {
        SingleChoiceSegmentedButtonRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEachIndexed { i, label ->
                SegmentedButton(
                    selected = selected == label,
                    onClick = { selected = label },
                    shape = SegmentedButtonDefaults.itemShape(i, items.size),
                    colors = SegmentedButtonDefaults.colors(
                        activeContainerColor = colorScheme.primary, activeContentColor = Color.White
                    ),
                    label = { Text(label, fontWeight = FontWeight.Bold) })
            }
        }
    }

}

@Composable
private fun CardSection() {
    GeneralCard {
        Text("DEneme")
    }
}