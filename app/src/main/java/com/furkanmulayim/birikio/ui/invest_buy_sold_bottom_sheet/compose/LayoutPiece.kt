package com.furkanmulayim.birikio.ui.invest_buy_sold_bottom_sheet.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.ui.invest_buy_sold_bottom_sheet.model.getLayoutPieceModel
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonIconsHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonMediumIconsHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.Padding
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingSmall
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingXSmall
import com.furkanmulayim.birikio.ui.theme.AppSize.RadiusMedium
import com.furkanmulayim.birikio.ui.theme.AppSize.one_dp
import com.furkanmulayim.birikio.ui.theme.AppSize.zero_o_five
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.twins_15
import com.furkanmulayim.birikio.ui.theme.twins_40
import com.furkanmulayim.birikio.ui.theme.twins_75

@Composable
fun InvestmentInputField(
    value: MutableState<String>,
    hint: String,
    isNumeric: Boolean,
    textStyle: androidx.compose.ui.text.TextStyle
) {
    BasicTextField(
        value = value.value,
        onValueChange = { newInput ->
            if (isNumeric) {
                // Ondalık sayı kontrolü: Sadece sayılar ve maksimum 1 tane nokta
                if (newInput.matches(Regex("^\\d*\\.?\\d{0,}$"))) {
                    value.value = newInput

                }
            } else {
                value.value = newInput
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = if(isNumeric) KeyboardType.Decimal else KeyboardType.Text
        ),
        singleLine = true,
        textStyle = textStyle,
        modifier = Modifier.fillMaxWidth(),
        decorationBox = { innerTextField ->
            if (value.value.isEmpty()) {
                Text(text = hint, style = textStyle.copy(color = twins_40))
            }
            innerTextField()
        })
}

@Composable
fun LayoutPiece(
    amount: MutableState<String>?,
    topAmount: MutableState<String>?,
    note: MutableState<String>?,
    rowType: String,
    imageName: String = ""
) {
    val model = getLayoutPieceModel(rowType, imageName)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(RadiusMedium))
            .border(
                width = zero_o_five, color = twins_75, shape = RoundedCornerShape(ButtonIconsHeight)
            )
            .padding(horizontal = Padding, vertical = Padding)
            .fillMaxWidth()
    ) {
        // Left Icon + Title
        Row(
            modifier = Modifier
                .padding(
                    top = PaddingSmall, bottom = PaddingXSmall, start = PaddingXSmall
                )
                .width(120.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(model.iconRes),
                contentDescription = "Investment Icon",
                modifier = Modifier
                    .size(ButtonMediumIconsHeight)
                    .clip(RoundedCornerShape(ButtonHeight))
                    .background(twins_15),
            )

            Column(modifier = Modifier.padding(start = Padding, end = Padding)) {
                Text(
                    text = model.subtitle,
                    style = Typo.font_10_w300.copy(color = colorScheme.onSecondary)
                )
                CustomSpacerHeight(3)
                Text(
                    text = model.title,
                    style = Typo.font_16_w500.copy(color = colorScheme.onSecondary)
                )
            }
        }

        // Vertical Divider
        Box(
            modifier = Modifier
                .width(one_dp)
                .background(twins_75)
                .height(50.dp)
        )

        // Right TextField
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = PaddingSmall, bottom = PaddingXSmall, start = PaddingXSmall),
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (model.inputType) {
                1 -> amount?.let {
                    InvestmentInputField(
                        it, model.hint, isNumeric = true, textStyle = Typo.font_25_w800.copy(
                            colorScheme.onSecondary, textAlign = TextAlign.Center
                        )
                    )
                }

                2 -> topAmount?.let {
                    InvestmentInputField(
                        it, model.hint, isNumeric = true, textStyle = Typo.font_25_w800.copy(
                            colorScheme.onSecondary, textAlign = TextAlign.Center
                        )
                    )
                }

                3 -> note?.let {
                    InvestmentInputField(
                        it, model.hint, isNumeric = false, textStyle = Typo.font_13_w500.copy(
                            colorScheme.onSecondary, textAlign = TextAlign.Center
                        )
                    )
                }
            }
        }
    }
}