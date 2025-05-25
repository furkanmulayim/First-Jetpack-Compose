package com.furkanmulayim.birikio.ui.buy_sold_bottom_sheet_wallet.model

import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.enums.WalletIncomeExpenseType
import com.furkanmulayim.birikio.ui.buy_sold_bottom_sheet_invest.model.LayoutPieceModel

fun getLayoutPieceModel(rowType: String): LayoutPieceModel {
    return when (rowType) {
        WalletIncomeExpenseType.AmountName.name -> LayoutPieceModel(
            iconRes = R.drawable.svg_wallet_name,
            title = "İsim",
            subtitle = "(Zorunlu)",
            hint = "Bkz. Banka Kartı Yatırım",
            inputType = 1
        )

        WalletIncomeExpenseType.Amount.name -> LayoutPieceModel(
            iconRes = R.drawable.png_wallet_name,
            title = "Miktar",
            subtitle = "(TL)",
            hint = "15.000",
            inputType = 2
        )

        WalletIncomeExpenseType.Nots.name -> LayoutPieceModel(
            iconRes = R.drawable.svg_invest_buy_sold_note,
            title = "Notlar",
            subtitle = "(OPSİYONEL)",
            hint = "Daha sonrası için kısa bir birikim notu girebilirsiniz. (Opsiyonel)",
            inputType = 3
        )

        WalletIncomeExpenseType.Date.name -> LayoutPieceModel(
            iconRes = R.drawable.svg_wallet_date,
            title = "Tarih",
            subtitle = "(Gün)",
            hint = "",
            inputType = 4
        )

        else -> LayoutPieceModel(
            iconRes = R.drawable.svg_money_error,
            title = "",
            subtitle = "",
            hint = "",
            inputType = 0
        )
    }
}