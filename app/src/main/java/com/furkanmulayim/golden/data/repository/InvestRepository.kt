package com.furkanmulayim.golden.data.repository

import com.furkanmulayim.golden.models.InvestModel

class InvestRepository {

    fun getInvestments(): List<InvestModel> {
        return listOf(
            InvestModel(
                id = 1,
                name = "Çeyrek Altın",
                count = "2",
                currentPrice = "2650",
                totalPrice = "5300",
                category = "1",
                notes = "Uzun vadeli yatırım"
            ), InvestModel(
                id = 2,
                name = "Gram Altın ₂₄",
                count = "5",
                currentPrice = "1900",
                totalPrice = "9500",
                category = "2",
                notes = "Günlük alım-satım için"
            ), InvestModel(
                id = 3,
                name = "Reşat Altın",
                count = "1",
                currentPrice = "2800",
                totalPrice = "2800",
                category = "3",
                notes = null
            ), InvestModel(
                id = 4,
                name = "Gram Altın  ₂₂",
                count = "3",
                currentPrice = "4500",
                totalPrice = "13500",
                category = "4",
                notes = "Düğün hediyesi olarak saklanıyor"
            )
        )
    }
}