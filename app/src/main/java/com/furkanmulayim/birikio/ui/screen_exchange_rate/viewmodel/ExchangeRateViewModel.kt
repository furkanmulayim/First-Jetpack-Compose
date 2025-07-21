package com.furkanmulayim.birikio.ui.screen_exchange_rate.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkanmulayim.birikio.core.extensions.calculateAllMoneys
import com.furkanmulayim.birikio.core.state.UiState
import com.furkanmulayim.birikio.data.repository.CurrencyRepository
import com.furkanmulayim.birikio.model.AllMoneys
import com.furkanmulayim.birikio.module.NetworkModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ExchangeRateViewModel(
    private val currencyRepository: CurrencyRepository = NetworkModule.provideCurrencyRepository(),
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<AllMoneys>>(UiState.Loading)
    val uiState: StateFlow<UiState<AllMoneys>> = _uiState

    private val _updatedAt = MutableStateFlow<String>("")
    val updatedAt: StateFlow<String> = _updatedAt

    private val _allMoneys = MutableStateFlow<AllMoneys>(AllMoneys(0.0, 0.0, 0, 0, 0, 0, 0, 0))
    val allMoneys: StateFlow<AllMoneys> = _allMoneys


    init {
        getRawGoldPrice()
    }

    private fun getRawGoldPrice() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                _allMoneys.value = calculateAllMoneys(currencyRepository.getCurrencies())
                _uiState.value = UiState.Success(_allMoneys.value)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage)
            }
        }
    }
}