package com.furkanmulayim.birikio.ui.bottom_sheet_income_expense_wallet.view

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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.core.enums.WalletExpenseCategoryEnum
import com.furkanmulayim.birikio.core.enums.WalletIncomeCategoryEnum
import com.furkanmulayim.birikio.core.enums.WalletIncomeExpenseType
import com.furkanmulayim.birikio.ui.bottom_sheet_income_expense_wallet.compose.CategoryPicker
import com.furkanmulayim.birikio.ui.bottom_sheet_income_expense_wallet.compose.LayoutPiece
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.ButtonXSmallHeight
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingLarge
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.greened
import com.furkanmulayim.birikio.ui.theme.soldDark

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WalletIncomeExpenseBottomSheet(
    showBottomSheet: Boolean, onDismiss: () -> Unit, walletType: String, isBuyColor: Boolean
) {
    println("furdebug: $isBuyColor")

    var walletAmount = remember { mutableStateOf("0") }
    var walletName = remember { mutableStateOf("") }
    var walletNote = remember { mutableStateOf("") }
    var walletDate = remember { mutableStateOf("") }
    val walletCategory = remember { mutableStateOf("") }

    LaunchedEffect(isBuyColor) {
        walletCategory.value =
            if (isBuyColor) WalletIncomeCategoryEnum.MAAS.value else WalletExpenseCategoryEnum.ALISVERIS.value
    }

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
                        text = walletType,
                        style = Typo.font_19_w500.copy(color = colorScheme.onSecondary)
                    )
                    CategoryPicker(walletCategory, isBuyColor)
                }
                CustomSpacerHeight(16)
                LayoutPiece(
                    amount = walletAmount,
                    amountName = walletName,
                    note = walletNote,
                    date = walletDate,
                    rowType = WalletIncomeExpenseType.AmountName.name
                )
                CustomSpacerHeight(16)
                LayoutPiece(
                    amount = walletAmount,
                    amountName = walletName,
                    note = walletNote,
                    date = walletDate,
                    rowType = WalletIncomeExpenseType.Amount.name
                )
                CustomSpacerHeight(16)
                LayoutPiece(
                    amount = walletAmount,
                    amountName = walletName,
                    note = walletNote,
                    date = walletDate,
                    rowType = WalletIncomeExpenseType.Nots.name
                )
                CustomSpacerHeight(16)
                LayoutPiece(
                    amount = walletAmount,
                    amountName = walletName,
                    note = walletNote,
                    date = walletDate,
                    rowType = WalletIncomeExpenseType.Date.name
                )
                CustomSpacerHeight(16)
                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(ButtonHeight),
                    onClick = {
                        // TODO:  adam burada 0 ve 0 girerse kullanıcıya toast gösterilecek. 0 adet olamaz diye!
                        walletAmount.value = "0"
                        walletName.value = ""
                        walletNote.value = ""
                        walletDate.value = ""
                        onDismiss()
                    },
                    shape = RoundedCornerShape(ButtonXSmallHeight),
                    enabled = walletAmount.value.isNotEmpty() && walletName.value.isNotEmpty() && walletDate.value.isNotEmpty(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isBuyColor) greened else soldDark,
                        contentColor = colorScheme.onPrimary
                    )
                ) {
                    Text(
                        text = walletType,
                        textAlign = TextAlign.Center,
                        style = Typo.font_19_w500.copy(color = colorScheme.onPrimary)
                    )
                }
            }
        }
    }
}
