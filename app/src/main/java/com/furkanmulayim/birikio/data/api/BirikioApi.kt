package com.furkanmulayim.birikio.data.api

import com.furkanmulayim.birikio.model.RawGoldPrice
import com.google.gson.JsonObject
import retrofit2.http.GET

interface BirikioApi {
    @GET("price/XAU")
    suspend fun getGoldPrice(): RawGoldPrice

    @GET("v4/today.json")
    suspend fun getCurrencyData(): JsonObject
}