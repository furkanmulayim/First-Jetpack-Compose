package com.furkanmulayim.birikio.feature.screen_home.ui.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkanmulayim.birikio.core.state.GoldUiState
import com.furkanmulayim.birikio.feature.screen_home.data.model.TickerItem
import com.furkanmulayim.birikio.feature.screen_home.data.repo.CurrencyRepository
import com.furkanmulayim.birikio.feature.screen_home.di.NetworkModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val currencyRepository: CurrencyRepository = NetworkModule.provideCurrencyRepository(),
) : ViewModel() {

    /** API LAST UPDATE */
    private val _tickers = MutableStateFlow<List<TickerItem>>(emptyList())
    val tickers: StateFlow<List<TickerItem>> = _tickers

    /**  API LAST UPDATE */
    private val _lastUpdate = MutableStateFlow("")
    val lastUpdate: StateFlow<String> = _lastUpdate

    /** UI STATES */
    private val _uiState = MutableStateFlow<GoldUiState<List<TickerItem>>>(GoldUiState.Loading)
    val uiState: StateFlow<GoldUiState<List<TickerItem>>> = _uiState

    fun retryFetchData() {
        getRawGoldPrice()
    }

    fun getRawGoldPrice() {
        viewModelScope.launch {
            _uiState.value = GoldUiState.Loading
            try {
                val result = currencyRepository.getTickers()
                _tickers.value = result.items
                _lastUpdate.value = result.updateDate
                _uiState.value = GoldUiState.Success(tickers.value)
            } catch (e: Exception) {
                _uiState.value = GoldUiState.Error(e.localizedMessage)
            }
        }
    }
}