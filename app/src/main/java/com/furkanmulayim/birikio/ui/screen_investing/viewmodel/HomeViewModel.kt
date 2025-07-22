package com.furkanmulayim.birikio.ui.screen_investing.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkanmulayim.birikio.core.extensions.calculateAllMoneys
import com.furkanmulayim.birikio.core.state.GoldUiState
import com.furkanmulayim.birikio.data.repository.CurrencyRepository
import com.furkanmulayim.birikio.data.repository.InvestRepository
import com.furkanmulayim.birikio.model.AllMoneys
import com.furkanmulayim.birikio.model.InvestModel
import com.furkanmulayim.birikio.module.NetworkModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val currencyRepository: CurrencyRepository = NetworkModule.provideCurrencyRepository(),
) : ViewModel() {


    private val _today = MutableStateFlow("")
    val today: MutableStateFlow<String> = _today

    private val _investingBalance = MutableStateFlow("")
    val investingBalance: MutableStateFlow<String> = _investingBalance

    private val _investmentList = MutableStateFlow<List<InvestModel>?>(emptyList())
    val investmentList: StateFlow<List<InvestModel>?> = _investmentList


    private val _uiState = MutableStateFlow<GoldUiState<AllMoneys>>(GoldUiState.Loading)
    val uiState: StateFlow<GoldUiState<AllMoneys>> = _uiState

    private val _allMoneys = MutableStateFlow(AllMoneys(0.0, 0.0, 0, 0, 0, 0, 0, 0))
    val allMoneys: StateFlow<AllMoneys> = _allMoneys


    init {
        getRawGoldPrice()
        fetchTodayDay()
        fetchInvestingBalance()
        fetchInvestments()
    }

    private fun getRawGoldPrice() {
        viewModelScope.launch {
            _uiState.value = GoldUiState.Loading
            try {
                _allMoneys.value = calculateAllMoneys(currencyRepository.getCurrencies())
                _uiState.value = GoldUiState.Success(_allMoneys.value)
            } catch (e: Exception) {
                _uiState.value = GoldUiState.Error(e.localizedMessage)
            }
        }
    }


    fun fetchInvestments() {
        _investmentList.value = InvestRepository().getInvestments()
    }

    fun fetchInvestingBalance() {
        investingBalance.value = "74.239"
    }

    fun fetchTodayDay() {
        today.value = "12 Şubat Salı"
    }
}