package com.furkanmulayim.birikio.feature.screen_home.data.model

// price: base currency value in TRY (1 unit of code -> price TRY)

data class RateCurrency(
    val name: String,
    val icon: Int,
    val code: String,
    val price: String,
)