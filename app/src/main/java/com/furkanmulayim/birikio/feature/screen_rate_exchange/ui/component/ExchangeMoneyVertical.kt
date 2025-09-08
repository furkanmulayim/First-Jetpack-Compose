package com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme.colorScheme
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.buttons.CustomIconMiniButton
import com.furkanmulayim.birikio.design.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import com.furkanmulayim.birikio.design.theme.primaryContainer
import com.furkanmulayim.birikio.feature.screen_home.data.model.RateCurrency
import kotlin.math.round

private fun calculateConvertedAmount(
    currencies: List<RateCurrency>, leftAmount: String, leftCode: String, rightCode: String,
): String {
    val l =
        currencies.firstOrNull { it.code == leftCode }?.price?.replace(",", ".")?.toDoubleOrNull()
            ?: 1.0
    val r =
        currencies.firstOrNull { it.code == rightCode }?.price?.replace(",", ".")?.toDoubleOrNull()
            ?: 1.0
    val amount = leftAmount.replace(",", ".").toDoubleOrNull() ?: 0.0
    val converted = amount * (l / r)
    return formatAmount(converted)
}

@Composable
fun ExchangeMoneyVertical(list: List<RateCurrency>) {

    val textLeftAmount = stringResource(R.string.exchangeLeftAmount)

    var leftAmount by remember { mutableStateOf(textLeftAmount) }
    var leftCode by remember { mutableStateOf("USD") }
    var rightCode by remember { mutableStateOf("TL") }

    var rightAmount = remember(leftAmount, leftCode, rightCode, list) {
        calculateConvertedAmount(list, leftAmount, leftCode, rightCode)
    }
    Text(
        modifier = Modifier.padding(top = Appsize.padding16, start = Appsize.padding16),
        text = "$leftAmount $leftCode = $rightAmount $rightCode",
        style = Typo.font_12_w500
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(bottomStart = Appsize.radius16, bottomEnd = Appsize.radius16))
            .background(colorScheme.primaryContainer)
            .padding(Appsize.padding12),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LeftExchangeItem(
            amount = leftAmount,
            onAmountChange = { leftAmount = it },
            selectedCode = leftCode,
            onCodeChange = { leftCode = it },
            codes = list.map { it.code },
            currencies = list
        )
        Spacer(Modifier.height(Appsize.size4))

        CustomIconMiniButton(R.drawable.home_button_exchange_vertical) {
            leftCode = rightCode.also { rightCode = leftCode }
            leftAmount = rightAmount.also { rightAmount = leftAmount }
        }
        Spacer(Modifier.height(Appsize.size4))

        RightExchangeItem(
            amount = rightAmount,
            selectedCode = rightCode,
            onCodeChange = { rightCode = it },
            codes = list.map { it.code },
            currencies = list
        )
    }
}

@Composable
private fun LeftExchangeItem(
    modifier: Modifier = Modifier,
    amount: String,
    onAmountChange: (String) -> Unit,
    selectedCode: String,
    onCodeChange: (String) -> Unit,
    codes: List<String>,
    currencies: List<RateCurrency>,
) {
    Row(
        modifier = modifier
            .height(Appsize.doubleButtonSize)
            .clip(RoundedCornerShape(Appsize.radius18))
            .background(color = colorScheme.surfaceVariant),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        BasicTextField(
            value = amount,
            onValueChange = { raw -> onAmountChange(raw.filter { it.isDigit() || it == '.' || it == ',' }) },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = Typo.font_15_w500.copy(
                textAlign = TextAlign.Center, color = colorScheme.inverseSurface
            ),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = Appsize.padding4)
                .height(Appsize.bottomTextIConButtonSize)
                .clip(RoundedCornerShape(Appsize.radius16))
                .background(colorScheme.surfaceBright),
            decorationBox = { innerTextField ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(Appsize.radius16))
                        .padding(vertical = Appsize.padding8),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
                    ) {
                        if (amount.isEmpty()) {
                            Text("", style = Typo.font_15_w500, textAlign = TextAlign.Center)
                        }
                        innerTextField()
                    }
                }
            })
        CurrencyPicker(
            selectedCode = selectedCode,
            onCodeChange = onCodeChange,
            codes = codes,
            currencies = currencies
        )
    }
}

@Composable
private fun RightExchangeItem(
    modifier: Modifier = Modifier,
    amount: String,
    selectedCode: String,
    onCodeChange: (String) -> Unit,
    codes: List<String>,
    currencies: List<RateCurrency>,
) {
    Row(
        modifier = modifier
            .height(Appsize.doubleButtonSize)
            .clip(RoundedCornerShape(Appsize.radius18))
            .background(colorScheme.surfaceVariant),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = Appsize.padding4)
                .height(Appsize.bottomTextIConButtonSize)
                .clip(RoundedCornerShape(Appsize.radius16)) // tek clip yeterli
                .background(colorScheme.surfaceBright)
        ) {
            Text(
                text = amount,
                style = Typo.font_15_w500.copy(
                    textAlign = TextAlign.Center, color = colorScheme.inverseSurface
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.align(Alignment.Center) // dikey + yatay merkez
            )
        }

        CurrencyPicker(
            selectedCode = selectedCode,
            onCodeChange = onCodeChange,
            codes = codes,
            currencies = currencies
        )
    }
}

@Composable
private fun CurrencyPicker(
    selectedCode: String,
    onCodeChange: (String) -> Unit,
    codes: List<String>,
    currencies: List<RateCurrency>,
) {
    var expanded by remember { mutableStateOf(false) }
    val padding4 = Appsize.padding10

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(Appsize.radius8))
            .width(100.dp)
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }) { expanded = true },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        CustomSpacerWidth(padding4)

        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .background(primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            val currency = currencies.firstOrNull { it.code == selectedCode }
            if (currency != null) {
                Image(
                    painter = painterResource(id = currency.icon),
                    contentDescription = currency.name,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                )
            }
        }
        CustomSpacerWidth(padding4)
        Text(selectedCode, style = Typo.font_15_w600)

        CustomSpacerWidth(Appsize.size8)
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            codes.forEach { code ->
                DropdownMenuItem(text = { Text(code) }, onClick = {
                    onCodeChange(code)
                    expanded = false
                })
            }
        }
        CustomSpacerWidth(padding4)
    }
}

private fun formatAmount(value: Double): String {
    val rounded = round(value * 100.0) / 100.0
    return if (rounded % 1.0 == 0.0) rounded.toInt().toString() else rounded.toString()
}
