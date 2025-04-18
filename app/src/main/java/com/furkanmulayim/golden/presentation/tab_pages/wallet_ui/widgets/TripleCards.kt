package com.furkanmulayim.golden.presentation.tab_pages.wallet_ui.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.furkanmulayim.golden.core.component.StatCard
import com.furkanmulayim.golden.presentation.theme.AppSize


@Composable
fun TripleCards(invest: String, outvest: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AppSize.PaddingLarge),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatCard(
            value = "$invest₺",
            label = "Toplam Gelir",
            valueColor = MaterialTheme.colorScheme.onTertiary
        )

        StatCard(
            value = "$outvest₺",
            label = "Toplam Gider",
            valueColor = MaterialTheme.colorScheme.inverseSurface
        )

        StatCard(
            value = "+44.43%",
            label = "Tasarruf", valueColor = Color.White
        )
    }
}
