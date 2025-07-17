package com.furkanmulayim.birikio.module

import com.furkanmulayim.birikio.data.api.BirikioApi
import com.furkanmulayim.birikio.data.repository.CurrencyRepository
import com.furkanmulayim.birikio.data.repository.CurrencyRepositoryImpl
import com.furkanmulayim.birikio.data.repository.RawGoldRepository
import com.furkanmulayim.birikio.data.repository.RawGoldRepositoryImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    private const val FIN_URL = "https://finans.truncgil.com/"
    private const val GOLD_URL = "https://api.gold-api.com/"

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

    fun provideGoldRepository(): RawGoldRepository {
        val api = createApiService(GOLD_URL)
        return RawGoldRepositoryImpl(api)
    }
}