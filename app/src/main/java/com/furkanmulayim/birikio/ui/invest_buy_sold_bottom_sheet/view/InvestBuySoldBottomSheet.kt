package com.furkanmulayim.birikio.ui.invest_buy_sold_bottom_sheet.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.core.enums.InvestmentAction
import com.furkanmulayim.birikio.ui.invest_buy_sold_bottom_sheet.compose.InvestmentToggleButton
import com.furkanmulayim.birikio.ui.theme.AppSize.PaddingLarge

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InvestBuySoldBottomSheet(
    showBottomSheet: Boolean, onDismiss: () -> Unit
) {
    if (true) {
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
                InvestmentToggleButton(
                    modifier = Modifier.fillMaxWidth(), onActionSelected = { selectedAction ->
                        when (selectedAction) {
                            InvestmentAction.Buy -> {
                                // "Yatırım Al" seçildiğinde yapılacak işlemler
                                println("Yatırım Al seçildi")
                            }

                            InvestmentAction.Sell -> {
                                // "Yatırım Sat" seçildiğinde yapılacak işlemler
                                println("Yatırım Sat seçildi")
                            }
                        }
                    })

                CustomSpacerHeight(8)

                val sampleItems = listOf(
                    "Item 1",
                    "Item 2",
                    "Item 3",
                    "Item 4",
                    "Item 5",
                    "Item 6",
                    "Item 7",
                    "Item 8",
                    "Item 9",
                    "Item 10",
                    "Item 11",
                    "Item 12",
                    "Item 13",
                    "Item 14",
                    "Item 15",
                    "Item 16",
                    "Item 17",
                    "Item 18",
                    "Item 19",
                    "Item 20"
                )
            }
        }
    }
}
