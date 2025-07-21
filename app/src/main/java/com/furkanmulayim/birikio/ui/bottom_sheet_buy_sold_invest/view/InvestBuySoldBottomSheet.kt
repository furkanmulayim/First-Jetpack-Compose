package com.furkanmulayim.birikio.ui.bottom_sheet_buy_sold_invest.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.core.enums.InvestE
import com.furkanmulayim.birikio.core.enums.InvestmentBuySoldType
import com.furkanmulayim.birikio.ui.bottom_sheet_buy_sold_invest.compose.CurrencyPicker
import com.furkanmulayim.birikio.ui.bottom_sheet_buy_sold_invest.compose.LayoutPiece
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonXSmallHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingLarge
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.greened
import com.furkanmulayim.birikio.ui.theme.soldDark
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvestBuySoldBottomSheet(
    showBottomSheet: Boolean, onDismiss: () -> Unit, investType: String, isBuyColor: Boolean
) {

    var amount = remember { mutableStateOf("") }
    var amountTotalLiras = remember { mutableStateOf("") }
    var subAmountTotal: Double = 0.0
    if (amount.value.isNotEmpty() && amountTotalLiras.value.isNotEmpty()) {
        subAmountTotal = (amount.value.toDouble() * amountTotalLiras.value.toDouble())
        subAmountTotal = (subAmountTotal * 100).roundToInt() / 100.0
    }

    var nots = remember { mutableStateOf("") }
    var invest = remember { mutableStateOf(InvestE.DOLLAR.value) }

    if (showBottomSheet) {
        ModalBottomSheet(
            sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
            onDismissRequest = onDismiss
        ) {
            Column(
                modifier = Modifier.padding(
                    start = PaddingLarge, end = PaddingLarge, bottom = PaddingLarge
                )
            ) {
                CustomSpacerHeight(8)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = investType,
                        style = Typo.font_19_w500.copy(color = colorScheme.onSecondary)
                    )
                    CurrencyPicker(invest)
                }

                CustomSpacerHeight(16)

                // KUR TİPİ
                LayoutPiece(
                    amount = amount,
                    rowType = InvestmentBuySoldType.Amount.name,
                    imageName = invest.value,
                    topAmount = null,
                    note = null
                )
                CustomSpacerHeight(16)

                // FİYAT
                LayoutPiece(
                    topAmount = amountTotalLiras,
                    rowType = InvestmentBuySoldType.AmountTotalLiras.name,
                    note = null,
                    amount = null
                )
                CustomSpacerHeight(16)
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = " Toplam $subAmountTotal",
                    textAlign = TextAlign.Start,
                    style = Typo.font_13_w500.copy(color = if (isBuyColor) greened else soldDark)
                )

                CustomSpacerHeight(16)

                // NOTES
                LayoutPiece(
                    note = nots,
                    rowType = InvestmentBuySoldType.Nots.name,
                    topAmount = null,
                    amount = null
                )
                CustomSpacerHeight(16)

                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ButtonHeight),
                    onClick = {
                        // TODO:  adam burada 0 ve 0 girerse kullanıcıya toast gösterilecek. 0 adet olamaz diye!
                        amount.value = ""
                        amountTotalLiras.value = ""
                        onDismiss()
                    },
                    shape = RoundedCornerShape(ButtonXSmallHeight),
                    enabled = amount.value.isNotEmpty() && amountTotalLiras.value.isNotEmpty(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isBuyColor) greened else soldDark,
                        contentColor = colorScheme.onPrimary
                    )
                ) {
                    Text(
                        text = investType,
                        textAlign = TextAlign.Center,
                        style = Typo.font_19_w500.copy(color = colorScheme.onPrimary)
                    )
                }
            }
        }
    }
}
