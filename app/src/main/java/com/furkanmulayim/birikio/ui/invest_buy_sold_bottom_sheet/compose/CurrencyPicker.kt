package com.furkanmulayim.birikio.ui.invest_buy_sold_bottom_sheet.compose


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.enums.InvestImageEnum
import com.furkanmulayim.birikio.core.extensions.getInvestNameToImage
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonIconsHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonMediumIconsHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ItemMaxImage
import com.furkanmulayim.birikio.ui.theme.AppSize.Padding
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingSmall
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingXSmall
import com.furkanmulayim.birikio.ui.theme.AppSize.RadiusButtons
import com.furkanmulayim.birikio.ui.theme.twins_10
import com.furkanmulayim.birikio.ui.theme.twins_15

@Composable
fun CurrencyPicker(
    selectedCurrency: MutableState<String>
) {
    var expanded by remember { mutableStateOf(false) }
    val options = mutableListOf<String>()
    var itemIcon = selectedCurrency.value.getInvestNameToImage()

    for (i in InvestImageEnum.entries) {
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
            Row(
                modifier = Modifier
                    .size(ItemMaxImage - PaddingSmall)
                    .clip(RoundedCornerShape(RadiusButtons)),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(itemIcon),
                        contentDescription = "Investment Icon",
                        modifier = Modifier
                            .size(ButtonMediumIconsHeight)
                            .clip(RoundedCornerShape(ButtonHeight))
                            .background(twins_15),
                    )
                }
            }

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