package com.furkanmulayim.golden.presentation.rate_page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.buttons.icon_button.CustomIconButton
import com.furkanmulayim.golden.core.component.others.CustomLine
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.Typo
import com.furkanmulayim.golden.presentation.theme.blued
import com.furkanmulayim.golden.presentation.theme.twins_15

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CurrentRateScreen(
    showBottomSheet: Boolean, onDismiss: () -> Unit
) {
    if (showBottomSheet) {
        var fromCurrency = remember { mutableStateOf("EUR") }
        var toCurrency = remember { mutableStateOf("USD") }

        var topAmount = remember { mutableStateOf("150") }
        var bottomAmount = remember { mutableStateOf("139.2") }

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
                HeaderAndCalculus(
                    topAmount = topAmount,
                    bottomAmount = bottomAmount,
                    fromCurrency = fromCurrency,
                    toCurrency = toCurrency
                )
                CustomSpacerHeight(16)
                CurrencyUnitsRow(amount = topAmount, currency = fromCurrency, isTop = true)
                DividerAndRate(
                    fromCurrency = fromCurrency, toCurrency = toCurrency
                )
                CurrencyUnitsRow(amount = bottomAmount, currency = toCurrency, isTop = false)
                CustomSpacerHeight(16)
            }
        }
    }
}

@Composable
fun HeaderAndCalculus(
    topAmount: MutableState<String>,
    bottomAmount: MutableState<String>,
    fromCurrency: MutableState<String>,
    toCurrency: MutableState<String>
) {

    val primColor = MaterialTheme.colorScheme.primary
    Row(
        modifier = Modifier
            .background(
                color = twins_15, shape = MaterialTheme.shapes.medium
            )
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.svg_rate_currency),
            tint = blued,
            contentDescription = "icon",
            modifier = Modifier.size(AppSize.ButtonIconsHeight),
        )
        CustomSpacerWidth(8)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = topAmount.value, style = Typo.font_16_w500.copy(primColor)
            )
            Text(
                text = " ${fromCurrency.value}", style = Typo.font_16_w500.copy(primColor)
            )
            Text(
                text = " = ", style = Typo.font_19_w500.copy(blued)
            )
            Text(
                text = bottomAmount.value, style = Typo.font_16_w500.copy(primColor)
            )
            Text(
                text = " ${toCurrency.value}", style = Typo.font_16_w500.copy(primColor)
            )
        }

    }
}

@Composable
fun CurrencyUnitsRow(
    amount: MutableState<String>, currency: MutableState<String>, isTop: Boolean
) {
    Row(
        modifier = Modifier
            .padding(top = AppSize.PaddingLarge)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (isTop) {
            PlainNumberInput(value = amount)
        } else {
            Text(
                text = amount.value,
                style = Typo.font_25_w800.copy(MaterialTheme.colorScheme.primary)
            )
        }
        CurrencyPicker(
            selectedCurrency = currency
        )


    }
}


@Composable
fun PlainNumberInput(
    value: MutableState<String>
) {
    BasicTextField(
        value = value.value,
        onValueChange = { newValue ->
            if (newValue.all { it.isDigit() }) {
                value.value = newValue
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        textStyle = Typo.font_25_w800.copy(MaterialTheme.colorScheme.primary)

    )
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

@Composable
fun CurrencyPicker(
    selectedCurrency: MutableState<String>,
) {
    var expanded by remember { mutableStateOf(false) }
    var options: List<String> = listOf("TL", "EUR", "USD")

    Box(
        modifier = Modifier.wrapContentSize(Alignment.TopStart)
    ) {
        OutlinedButton(
            onClick = { expanded = true }, modifier = Modifier.width(100.dp)
        ) {
            Text(text = selectedCurrency.value)
        }

        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    selectedCurrency.value = option
                }, text = { Text(option) })
            }
        }
    }
}