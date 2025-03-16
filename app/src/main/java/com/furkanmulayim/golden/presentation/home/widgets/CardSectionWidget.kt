package com.furkanmulayim.golden.presentation.home.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.furkanmulayim.golden.models.InvestModel


@Composable
fun InvestListItem(investment: InvestModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = investment.name, style = MaterialTheme.typography.titleLarge)
            Text(
                text = "Adet: ${investment.count}", style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Güncel Fiyat: ${investment.currentPrice} TL",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Toplam Değer: ${investment.totalPrice} TL",
                style = MaterialTheme.typography.bodyMedium
            )

            investment.notes?.let {
                Text(text = "Not: $it", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
