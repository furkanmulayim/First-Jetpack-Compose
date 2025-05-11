package com.furkanmulayim.birikio.data.repository

import com.furkanmulayim.birikio.model.InvestModel

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
                isBuyed = true,
                notes = "Uzun vadeli yatırım"
            ),
            InvestModel(
                id = 2,
                name = "Gram Altın ₂₄",
                count = "5",
                currentPrice = "1900",
                totalPrice = "9500",
                category = "2",
                isBuyed = true,
                notes = "Günlük alım-satım için"
            ),
            InvestModel(
                id = 3,
                name = "Reşat Altın",
                count = "1",
                currentPrice = "2800",
                totalPrice = "2800",
                category = "3",
                isBuyed = false,
                notes = null
            ),
            InvestModel(
                id = 2,
                name = "Dolar",
                count = "5",
                currentPrice = "1900",
                totalPrice = "9500",
                category = "2",
                isBuyed = false,
                notes = "Günlük alım-satım için"
            ),
            InvestModel(
                id = 2,
                name = "Euro",
                count = "20",
                currentPrice = "41",
                totalPrice = "820",
                category = "2",
                isBuyed = true,
                notes = "Günlük alım-satım için"
            ),
            InvestModel(
                id = 2,
                name = "Çeyrek Altın",
                count = "5",
                currentPrice = "4500",
                totalPrice = "2500",
                category = "2",
                isBuyed = false,
                notes = "Günlük alım-satım için"
            ),
            InvestModel(
                id = 2,
                name = "Tam Altın",
                count = "5",
                currentPrice = "1900",
                totalPrice = "9500",
                category = "2",
                isBuyed = false,
                notes = "Günlük alım-satım için"
            ),
        )
    }
}