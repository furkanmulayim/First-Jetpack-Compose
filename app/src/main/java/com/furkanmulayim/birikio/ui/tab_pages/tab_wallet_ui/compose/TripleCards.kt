package com.furkanmulayim.birikio.ui.tab_pages.tab_wallet_ui.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.furkanmulayim.birikio.core.component.StatCard
import com.furkanmulayim.birikio.ui.theme.AppSize


@Composable
fun TripleCards(invest: String, outvest: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = AppSize.PaddingLarge),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatCard(
            value = "$invest₺", label = "Toplam Gelir", valueColor = colorScheme.onTertiary
        )

        StatCard(
            value = "$outvest₺", label = "Toplam Gider", valueColor = colorScheme.inverseSurface
        )

        StatCard(
            value = "+44.43%", label = "Tasarruf", valueColor = colorScheme.onSecondary
        )
    }
}
