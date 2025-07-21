package com.furkanmulayim.birikio.module

import com.furkanmulayim.birikio.data.api.BirikioApi
import com.furkanmulayim.birikio.data.repository.CurrencyRepository
import com.furkanmulayim.birikio.data.repository.CurrencyRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private const val FIN_URL = "https://finans.truncgil.com/"

    private fun createApiService(baseUrl: String): BirikioApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BirikioApi::class.java)
    }

    fun provideCurrencyRepository(): CurrencyRepository {
        val api = createApiService(FIN_URL)
        return CurrencyRepositoryImpl(api)
    }
}