package com.furkanmulayim.golden.presentation.tab_main.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.buttons.icon_button.CustomIconButton
import com.furkanmulayim.golden.core.component.others.CustomLine
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.Typo
import com.furkanmulayim.golden.presentation.theme.twins_15

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowSettingsBottomSheet(
    showBottomSheet: Boolean, onDismiss: () -> Unit
) {
    if (true) {
        val fromCurrency = remember { mutableStateOf("€") }
        val toCurrency = remember { mutableStateOf("$") }

        ModalBottomSheet(
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false),
            onDismissRequest = onDismiss
        ) {
            Column(
                modifier = Modifier.padding(
                    start = AppSize.PaddingLarge,
                    end = AppSize.PaddingLarge,
                    bottom = AppSize.PaddingLarge
                )
            ) {
                HeaderAndCalculus(fromCurrency = fromCurrency.value, toCurrency = toCurrency.value)
                CustomSpacerHeight(16)
                CurrencyUnitsRow(amount = "150", currency = fromCurrency.value)
                DividerAndRate(
                    fromCurrency = fromCurrency, toCurrency = toCurrency
                )
                CurrencyUnitsRow(amount = "139.000", currency = toCurrency.value)
                CustomSpacerHeight(16)
            }
        }
    }
}

@Composable
fun HeaderAndCalculus(fromCurrency: String, toCurrency: String) {
    Row(
        modifier = Modifier
            .background(
                color = twins_15, shape = MaterialTheme.shapes.medium
            )
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.svg_rate_currency),
            tint = MaterialTheme.colorScheme.onSecondary,
            contentDescription = "icon",
            modifier = Modifier.size(AppSize.ButtonIconsHeight),
        )
        CustomSpacerWidth(8)
        Text(
            text = "1$fromCurrency = 0.9321$toCurrency",
            style = Typo.font_19_w600.copy(MaterialTheme.colorScheme.primary)
        )
    }
}

@Composable
fun CurrencyUnitsRow(amount: String, currency: String) {
    Row(
        modifier = Modifier
            .padding(top = AppSize.PaddingLarge)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = amount, style = Typo.font_40_w800.copy(MaterialTheme.colorScheme.primary)
        )
        Text(
            text = currency, style = Typo.font_40_w800.copy(MaterialTheme.colorScheme.primary)
        )
    }
}

@Composable
fun DividerAndRate(
    fromCurrency: MutableState<String>, toCurrency: MutableState<String>
) {
    CustomSpacerHeight(16)
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomLine(130.dp)
        CustomSpacerWidth(12)
        CustomIconButton(R.drawable.svg_live_data, onClick = {
            // swap işlemi
            val temp = fromCurrency.value
            fromCurrency.value = toCurrency.value
            toCurrency.value = temp
        })
        CustomSpacerWidth(12)
        CustomLine(130.dp)
    }

    CustomSpacerHeight(8)
}