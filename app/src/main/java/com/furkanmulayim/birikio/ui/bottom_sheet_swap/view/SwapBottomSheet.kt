package com.furkanmulayim.birikio.ui.bottom_sheet_swap.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.core.component.others.CustomSpacerWidth
import com.furkanmulayim.birikio.core.enums.SwapImageEnum
import com.furkanmulayim.birikio.core.extensions.getSwapNameToImage
import com.furkanmulayim.birikio.ui.bottom_sheet_swap.compose.CustomIconSwapButton
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonIconsHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonMediumIconsHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ItemMaxImage
import com.furkanmulayim.birikio.ui.theme.AppSize.Padding
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingLarge
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingSmall
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingXLarge
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingXSmall
import com.furkanmulayim.birikio.ui.theme.AppSize.RadiusButtons
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.twins
import com.furkanmulayim.birikio.ui.theme.twins_10
import com.furkanmulayim.birikio.ui.theme.twins_15
import com.furkanmulayim.birikio.ui.theme.twins_40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwapBottomSheet(
    showBottomSheet: Boolean, onDismiss: () -> Unit
) {
    if (showBottomSheet) {
        val fromCurrency = remember { mutableStateOf(SwapImageEnum.TRY.value) }
        val toCurrency = remember { mutableStateOf(SwapImageEnum.DOLLAR.value) }

        val topAmount = remember { mutableStateOf("") }
        val bottomAmount = remember { mutableStateOf("") }

        ModalBottomSheet(
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false),
            onDismissRequest = onDismiss
        ) {
            Column(
                modifier = Modifier.padding(
                    start = PaddingLarge, end = PaddingLarge, bottom = PaddingLarge
                )
            ) {
                CustomSpacerHeight(8)
                CurrencyUnitsRow(amount = topAmount, currency = fromCurrency, isTop = true)
                DividerAndRate(
                    fromCurrency = fromCurrency, toCurrency = toCurrency
                )
                CurrencyUnitsRow(amount = bottomAmount, currency = toCurrency, isTop = false)
                CustomSpacerHeight(8)
            }
        }
    }
}

@Composable
fun CurrencyUnitsRow(
    amount: MutableState<String>, currency: MutableState<String>, isTop: Boolean
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(RadiusButtons))
            .background(twins_15)
            .padding(horizontal = PaddingXLarge, vertical = PaddingLarge)
            .fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier.padding(top = PaddingSmall, bottom = PaddingXSmall),
            text = if (isTop) "Biriminden" else "Birimine",
            style = Typo.font_13_w500.copy(twins)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (isTop) {
                PlainNumberInput(
                    value = amount, modifier = Modifier.weight(1f)
                )
            } else {
                Text(
                    text = amount.value,
                    modifier = Modifier.weight(1f),
                    style = Typo.font_25_w800.copy(colorScheme.primary)
                )
            }
            CustomSpacerWidth(12)
            CurrencyPicker(
                selectedCurrency = currency
            )
        }
    }
    GradientLine(
        modifier = Modifier.padding(horizontal = PaddingLarge)
    )

}

@Composable
fun PlainNumberInput(
    value: MutableState<String>,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        BasicTextField(
            value = value.value,
            onValueChange = { newValue ->
                // Sadece ondalıklı sayı formatına izin ver (maks. 1 tane nokta)
                if (newValue.matches(Regex("^\\d*\\.?\\d*$"))) {
                    value.value = newValue
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
            singleLine = true,
            textStyle = Typo.font_25_w800.copy(colorScheme.primary),
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                if (value.value.isEmpty()) {
                    Text(text = "0", style = Typo.font_25_w800.copy(color = twins_40))
                }
                innerTextField()
            }
        )
    }
}

@Composable
fun DividerAndRate(
    fromCurrency: MutableState<String>, toCurrency: MutableState<String>
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Absolute.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        CustomIconSwapButton(R.drawable.svg_icon_live_data, onClick = {
            // swap işlemi
            val temp = fromCurrency.value
            fromCurrency.value = toCurrency.value
            toCurrency.value = temp
        })
    }
}

@Composable
fun CurrencyPicker(
    selectedCurrency: MutableState<String>,
) {
    var expanded by remember { mutableStateOf(false) }
    val options = mutableListOf<String>()
    val itemIcon = selectedCurrency.value.getSwapNameToImage()

    for (i in SwapImageEnum.entries) {
        options.add(i.value)
    }

    Box(
        modifier = Modifier.wrapContentSize(Alignment.TopStart)
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(RadiusButtons))
                .background(twins_10)
                .clickable {
                    expanded = true
                }
                .height(ItemMaxImage)
                .padding(start = PaddingXSmall),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image(
                painter = painterResource(itemIcon),
                contentDescription = "Investment Icon",
                modifier = Modifier
                    .size(ButtonMediumIconsHeight)
                    .clip(RoundedCornerShape(ButtonHeight))
                    .background(twins_15),
            )

            Text(
                modifier = Modifier.padding(start = Padding, end = PaddingXSmall),
                text = selectedCurrency.value
            )
            Icon(
                painter = painterResource(id = R.drawable.svg_icon_arrow_down),
                contentDescription = "text",
                tint = colorScheme.primary,
                modifier = Modifier
                    .size(ButtonIconsHeight)
                    .padding(end = Padding)
            )

        }

        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        selectedCurrency.value = option
                    },
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(option, style = TextStyle(textAlign = TextAlign.Center))
                        }
                    },
                )
            }
        }
    }
}


@Composable
fun GradientLine(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .height(1.dp)
            .fillMaxWidth()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color.Transparent,
                        twins.copy(alpha = 0.3f),
                        twins.copy(alpha = 0.6f),
                        twins.copy(alpha = 0.3f),
                        Color.Transparent,
                    )
                )
            )
    )
}