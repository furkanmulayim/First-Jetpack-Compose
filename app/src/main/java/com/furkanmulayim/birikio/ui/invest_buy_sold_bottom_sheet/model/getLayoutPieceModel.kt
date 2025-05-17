package com.furkanmulayim.birikio.ui.invest_buy_sold_bottom_sheet.model

import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.enums.InvestImageEnum
import com.furkanmulayim.birikio.core.enums.InvestmentBuySoldType
import com.furkanmulayim.birikio.core.extensions.getInvestNameToImage

fun getLayoutPieceModel(rowType: String, imageName: String): LayoutPieceModel {
    return when (rowType) {
        InvestmentBuySoldType.Amount.name -> LayoutPieceModel(
            iconRes = imageName.getInvestNameToImage(),
            title = InvestImageEnum.fromValue(imageName)?.value.orEmpty(),
            subtitle = "(ADET)",
            hint = "0",
            inputType = 1
        )

        InvestmentBuySoldType.AmountTotalLiras.name -> LayoutPieceModel(
            iconRes = R.drawable.svg_invest_buy_sold_graph,
            title = "Fiyat",
            subtitle = "(TL)",
            hint = "0",
            inputType = 2
        )

        InvestmentBuySoldType.Nots.name -> LayoutPieceModel(
            iconRes = R.drawable.svg_invest_buy_sold_note,
            title = "Notlar",
            subtitle = "(OPSİYONEL)",
            hint = "Daha sonrası için kısa bir yatırım notu girebilirsiniz. (Opsiyonel)",
            inputType = 3
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