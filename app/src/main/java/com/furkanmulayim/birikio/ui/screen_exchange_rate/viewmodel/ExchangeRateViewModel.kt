package com.furkanmulayim.birikio.ui.screen_exchange_rate.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkanmulayim.birikio.core.extensions.calculateAllMoneys
import com.furkanmulayim.birikio.data.repository.CurrencyRepository
import com.furkanmulayim.birikio.data.repository.RawGoldRepository
import com.furkanmulayim.birikio.model.AllMoneys
import com.furkanmulayim.birikio.module.NetworkModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExchangeRateViewModel(
    private val currencyRepository: CurrencyRepository = NetworkModule.provideCurrencyRepository(),
    private val onsGoldRepository: RawGoldRepository = NetworkModule.provideGoldRepository(),
) : ViewModel() {

    private val _updatedAt = MutableStateFlow<String>("")
    val updatedAt: StateFlow<String> = _updatedAt

    private val _allMoneys = MutableStateFlow<AllMoneys?>(AllMoneys(0.0, 0.0, 0, 0, 0, 0, 0, 0))
    val allMoneys: StateFlow<AllMoneys?> = _allMoneys


    init {
        getRawGoldPrice()
    }

    private fun getRawGoldPrice() {
        viewModelScope.launch {
            try {
                val result = onsGoldRepository.getGoldPrice()
                _updatedAt.value = result.updatedAt
                var goldOns = result.price
                var currencies = currencyRepository.getCurrencies()

                if (goldOns != 0.0 && currencies.isNotEmpty()) {
                    _allMoneys.value = calculateAllMoneys(goldOns, currencies)
                }
            } catch (e: Exception) {
            }
        }
    }
}