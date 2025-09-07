package com.furkanmulayim.birikio.silinecekler

import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.feature.screen_home.data.model.RateCurrency
import com.furkanmulayim.birikio.feature.screen_home.data.model.RecentTransaction

val listBeDeletedCurrency = listOf(
    RateCurrency(
        name = "Dolar", icon = R.drawable.money_dollar, code = "USD", price = "42,35"
    ), RateCurrency(
        name = "Euro", icon = R.drawable.money_euro, code = "EUR", price = "45,35"
    ), RateCurrency(
        name = "Gram", icon = R.drawable.money_gram, code = "GR", price = "4535"
    ), RateCurrency(
        name = "TL", icon = R.drawable.money_try, code = "TL", price = "1"
    )
)

val listBeDeletedRecents = listOf(
    RecentTransaction(
        1, "Dolar", "12 Temmuz", 100.0, 32.0, 3200.0, R.drawable.money_dollar, true
    ),
    RecentTransaction(
        2, "Çeyrek", "12 Temmuz", 40.0, 6400.0, 25600.0, R.drawable.money_ceyrek, false
    ),
    RecentTransaction(
        3, "Euro", "12 Temmuz", 144.0, 350.0, 350.0, R.drawable.money_euro, false
    ),
)