package com.furkanmulayim.birikio.data.repository

import com.furkanmulayim.birikio.data.api.BirikioApi
import com.furkanmulayim.birikio.model.Currency
import com.furkanmulayim.birikio.model.CurrencyDto
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