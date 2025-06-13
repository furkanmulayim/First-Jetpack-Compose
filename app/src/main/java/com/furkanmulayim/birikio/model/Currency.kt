package com.furkanmulayim.birikio.model

import com.google.gson.annotations.SerializedName

data class Currency(
    val code: String,
    val name: String,
    val buying: Double,
    val selling: Double
)

data class CurrencyDto(
    @SerializedName("Name") val name: String,
    @SerializedName("Buying") val buying: Double,
    @SerializedName("Selling") val selling: Double
) {
    fun toCurrency(code: String): Currency {
        return Currency(
            code = code,
            name = name,
            buying = buying,
            selling = selling
        )
    }
}