package com.furkanmulayim.golden.presentation.investing.widgets

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.presentation.theme.CustomTypo


@Composable
fun InvestingBalanceSectionWidget(totalInvesting: String) {
    CustomSpacerHeight(24)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // TEXT -> MONEY
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = totalInvesting,
                style = CustomTypo.text.displayLarge.copy(color = MaterialTheme.colorScheme.onTertiaryContainer)
            )
            CustomSpacerWidth(5)
            Text(
                text = "₺",
                style = CustomTypo.text.displayLarge.copy(color = MaterialTheme.colorScheme.onTertiaryContainer)
            )
        }
    }
    CustomSpacerHeight(24)
}
