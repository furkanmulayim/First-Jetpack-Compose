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
import androidx.compose.runtime.collectAsState
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
import com.furkanmulayim.birikio.core.util.enums.CurrencyShortName.Companion.editDisplayName
import com.furkanmulayim.birikio.core.util.enums.CurrencyShortName.Companion.getImage
import com.furkanmulayim.birikio.core.util.enums.CurrencyShortName.Companion.getShortName
import com.furkanmulayim.birikio.design.component.buttons.CustomIconMiniButton
import com.furkanmulayim.birikio.design.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import com.furkanmulayim.birikio.design.theme.primaryContainer
import com.furkanmulayim.birikio.feature.screen_home.data.model.TickerItem
import kotlinx.coroutines.flow.StateFlow
import kotlin.math.round

fun calculateConvertedAmount(
    currencies: List<TickerItem>, leftAmount: String, leftCode: String, rightCode: String,
): String {
    val l =
        if (leftCode == "TL") 1.0 else currencies.firstOrNull { it.code == leftCode }?.selling?.toString()
            ?.replace(",", ".")?.toDoubleOrNull() ?: 1.0
    val r =
        if (rightCode == "TL") 1.0 else currencies.firstOrNull { it.code == rightCode }?.selling?.toString()
            ?.replace(",", ".")?.toDoubleOrNull() ?: 1.0
    val amount = leftAmount.replace(",", ".").toDoubleOrNull() ?: 0.0
    val converted = amount * (l / r)
    return formatAmount(converted)
}

@Composable
fun ExchangeMoneyVertical(list: StateFlow<List<TickerItem>>) {


    val tickers = list.collectAsState().value

    val textLeftAmount = stringResource(R.string.exchangeLeftAmount)

    var leftAmount by remember { mutableStateOf(textLeftAmount) }
    var leftCode by remember { mutableStateOf("USD") }
    var rightCode by remember { mutableStateOf("TL") }

    val rightAmount = remember(leftAmount, leftCode, rightCode, tickers) {
        calculateConvertedAmount(tickers, leftAmount, leftCode, rightCode)
    }
    Text(
        modifier = Modifier.padding(top = Appsize.padding16, start = Appsize.padding16),
        text = "$leftAmount ${editDisplayName(leftCode)} = $rightAmount ${editDisplayName(rightCode)}",
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
            codes = tickers.map { it.code },
            currencies = list
        )
        Spacer(Modifier.height(Appsize.size4))

        CustomIconMiniButton(R.drawable.home_button_exchange) {
            val currentRight = rightAmount
            val tmpCode = leftCode
            leftCode = rightCode
            rightCode = tmpCode
            leftAmount = currentRight
        }
        Spacer(Modifier.height(Appsize.size4))

        RightExchangeItem(
            amount = rightAmount,
            selectedCode = rightCode,
            onCodeChange = { rightCode = it },
            codes = tickers.map { it.code },
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
    currencies: StateFlow<List<TickerItem>>,
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
    currencies: StateFlow<List<TickerItem>>,
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
    currencies: StateFlow<List<TickerItem>>,
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
        val currency = currencies.collectAsState().value.firstOrNull { it.code == selectedCode }

        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .background(primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            if (currency != null) {
                Image(
                    painterResource(getImage(currency.code)),
                    contentDescription = currency.name,
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                )
            }
        }
        CustomSpacerWidth(padding4)
        Text(getShortName(currency?.name ?: ""), style = Typo.font_15_w600)

        CustomSpacerWidth(Appsize.size8)
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            codes.forEach { code ->
                DropdownMenuItem(text = { Text(editDisplayName(code)) }, onClick = {
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
