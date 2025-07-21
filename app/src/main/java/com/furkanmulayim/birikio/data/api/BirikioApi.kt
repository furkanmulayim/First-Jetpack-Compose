package com.furkanmulayim.birikio.data.api

import com.google.gson.JsonObject
import retrofit2.http.GET

interface BirikioApi {

    @GET("v4/today.json")
    suspend fun getCurrencyData(): JsonObject
}