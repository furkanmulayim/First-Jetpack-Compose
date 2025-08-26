package com.furkanmulayim.birikio.feature.screen_home.data.model

data class RecentTransaction(
    val id: Int,
    val name: String,
    val date: String,
    val count: Double,
    val amount: Double,
    val total: Double,
    val icon: Int,
    val isSold: Boolean
)