package com.furkanmulayim.birikio.feature.screen_home.data.repo

import com.furkanmulayim.birikio.feature.screen_home.data.model.Currency
import com.furkanmulayim.birikio.feature.screen_home.data.model.CurrencyDto
import com.furkanmulayim.birikio.feature.screen_home.data.remote.BirikioApi
import com.google.gson.Gson

interface CurrencyRepository {
    suspend fun getCurrencies(): List<Currency>
}

class CurrencyRepositoryImpl(
    private val api: BirikioApi
) : CurrencyRepository {

    override suspend fun getCurrencies(): List<Currency> {
        val response = api.getCurrencyData()

        val list = mutableListOf<Currency>()

        val gson = Gson()

        val keys = listOf("USD", "EUR", "GRA")
        for (key in keys) {
            if (response.has(key)) {
                val dto = gson.fromJson(response[key], CurrencyDto::class.java)
                list.add(dto.toCurrency(key))
            }
        }

        return list
    }
}