package com.furkanmulayim.birikio.core.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.textTwins

@Composable
fun StatCard(
    value: String, label: String, valueColor: Color
) {
    Card(
        modifier = Modifier
            .width(110.dp)
            .height(50.dp),
        colors = CardDefaults.cardColors(containerColor = colorScheme.background),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, colorScheme.secondary),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value, color = valueColor, style = Typo.font_13_w500
            )
            CustomSpacerHeight(4)
            Text(
                text = label,
                style = Typo.font_13_w500,
                textAlign = TextAlign.Left,
                color = textTwins
            )
        }
    }
}