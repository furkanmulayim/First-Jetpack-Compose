package com.furkanmulayim.birikio.ui.invest_buy_sold_bottom_sheet.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.core.enums.InvestmentAction

@Composable
fun InvestmentToggleButton(
    modifier: Modifier = Modifier, onActionSelected: (InvestmentAction) -> Unit
) {
    var selectedAction by remember { mutableStateOf(InvestmentAction.Buy) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color.LightGray, shape = RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceEvenly
    ) {
        InvestmentToggleItem(
            modifier = Modifier.weight(1f),
            text = "Yatırım Al",
            isSelected = selectedAction == InvestmentAction.Buy,
            onClick = {
                selectedAction = InvestmentAction.Buy
                onActionSelected(InvestmentAction.Buy)
            })
        InvestmentToggleItem(
            modifier = Modifier.weight(1f),
            text = "Yatırım Sat",
            isSelected = selectedAction == InvestmentAction.Sell,
            onClick = {
                selectedAction = InvestmentAction.Sell
                onActionSelected(InvestmentAction.Sell)
            })
    }
}

@Composable
private fun InvestmentToggleItem(
    modifier: Modifier = Modifier, text: String, isSelected: Boolean, onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(16.dp))
            .background(
                if (isSelected) Color(0xFFF9F9F9) else Color(0xFFCCCCCC)
            )
            .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isSelected) Color.Black else Color.Gray,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal)
        )
    }
}