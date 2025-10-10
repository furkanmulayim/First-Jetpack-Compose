package com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import com.furkanmulayim.birikio.design.theme.primaryContainer
import com.furkanmulayim.birikio.feature.screen_home.data.model.RateCurrency

@Composable
fun CurrencyPickerGenuine(
    selectedCode: String,
    onCodeChange: (String) -> Unit,
    list: List<String>,
    currencies: List<RateCurrency>,
) {
    var expanded by remember { mutableStateOf(false) }
    val padding4 = Appsize.padding10

    Row(
        modifier = Modifier
            .padding(Appsize.padding12)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }) { expanded = true },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CustomSpacerWidth(padding4)

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            val currency = currencies.firstOrNull { it.name == selectedCode }
            if (currency != null) {
                Image(
                    painter = painterResource(id = currency.icon),
                    contentDescription = currency.name,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
            }
        }
        CustomSpacerWidth(padding4)
        Column {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    selectedCode,
                    style = Typo.font_15_w500,
                    modifier = Modifier.padding(end = Appsize.size8)
                )

                Image(
                    painter = painterResource(R.drawable.change),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(bottom = Appsize.size3)
                        .size(Appsize.iconSize10)
                )
            }
            Row {
                Text(
                    stringResource(R.string.textCurrentPrice),
                    style = Typo.font_12_w300,
                    modifier = Modifier.padding(end = Appsize.size3)
                )
                Text("42.50₺", style = Typo.font_12_w500)
            }
        }
    }

    CustomSpacerWidth(Appsize.size8)
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        list.forEach { name ->
            DropdownMenuItem(text = { Text(name) }, onClick = {
                onCodeChange(name)
                expanded = false
            })
        }
    }
    CustomSpacerWidth(padding4)
}