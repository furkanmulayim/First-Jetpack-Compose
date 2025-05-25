package com.furkanmulayim.birikio.data.repository

import com.furkanmulayim.birikio.model.WalletModel

class WalletRepository {

    fun getWallet(): List<WalletModel> {
        return listOf(
            WalletModel(
                id = 1,
                name = "Kredi Kartı",
                count = "770",
                date = "2 Haz 2025",
                isBuyed = false,
                category = "Gider",
                notes = "deneme dememe denemek",
            ),
            WalletModel(
                id = 2,
                name = "Maaş",
                count = "77000",
                date = "5 Haz 2025",
                isBuyed = true,
                category = "Maaş",
                notes = "deneme dememe denemek",
            ),
            WalletModel(
                id = 2,
                name = "Kira",
                count = "20000",
                date = "5 Haz 2025",
                isBuyed = false,
                category = "Diğer",
                notes = "deneme dememe denemek",
            )
        )
    }
}