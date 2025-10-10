package com.furkanmulayim.birikio.feature.screen_home.data.repo

import android.util.Log
import com.furkanmulayim.birikio.core.util.enums.CurrencyShortName
import com.furkanmulayim.birikio.core.util.enums.CurrencyShortName.Companion.editDisplayName
import com.furkanmulayim.birikio.feature.screen_home.data.model.CurrencyRate
import com.furkanmulayim.birikio.feature.screen_home.data.model.TickerItem
import com.furkanmulayim.birikio.feature.screen_home.data.model.TickersResult
import com.furkanmulayim.birikio.feature.screen_home.data.remote.BirikioApi
import com.google.gson.Gson
import com.google.gson.JsonObject

interface CurrencyRepository {
    suspend fun getTickers(): TickersResult
}

class CurrencyRepositoryImpl(
    private val api: BirikioApi,
    private val gson: Gson = Gson(),
) : CurrencyRepository {

    override suspend fun getTickers(): TickersResult {
        val response = api.getCurrencyData()
        Log.e("FURDEBUG", "API response: $response")

        val json: JsonObject = when (response) {
            else -> response
        }

        val updateDate = json["Update_Date"].asString
        val rates = mutableListOf<TickerItem>()

        json.entrySet().forEach { (key, value) ->
            if (key != "Update_Date") {
                val rate = gson.fromJson(value.asJsonObject, CurrencyRate::class.java)
                if (CurrencyShortName.isAllowed(key)) {

                    rates.add(
                        TickerItem(
                            code = key,
                            name = editDisplayName(key),
                            type = rate.Type,
                            buying = rate.Buying,
                            selling = rate.Selling,
                            change = rate.Change
                        )
                    )
                }
            }
        }
        rates.add(
            TickerItem(
                code = "TL",
                name = "Türk Lirası",
                type = "Currency",
                buying = 1.0,
                selling = 1.0,
                change = 0.0
            )
        )
        return TickersResult(items = rates, updateDate = updateDate)
    }
}