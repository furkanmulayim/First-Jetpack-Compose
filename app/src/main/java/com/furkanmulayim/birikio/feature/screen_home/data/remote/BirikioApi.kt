package com.furkanmulayim.birikio.feature.screen_home.data.remote

import com.google.gson.JsonObject
import retrofit2.http.GET

interface BirikioApi {

    @GET("v4/today.json")
    suspend fun getCurrencyData(): JsonObject
}