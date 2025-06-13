package com.furkanmulayim.birikio.data.repository

import com.furkanmulayim.birikio.data.api.BirikioApi
import com.furkanmulayim.birikio.model.RawGoldPrice

interface RawGoldRepository {
    suspend fun getGoldPrice(): RawGoldPrice
}

class RawGoldRepositoryImpl(
    private val api: BirikioApi
) : RawGoldRepository {
    override suspend fun getGoldPrice(): RawGoldPrice {
        return api.getGoldPrice()
    }
}