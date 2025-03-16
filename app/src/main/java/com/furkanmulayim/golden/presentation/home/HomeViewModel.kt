package com.furkanmulayim.golden.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.furkanmulayim.golden.data.repository.InvestRepository
import com.furkanmulayim.golden.models.InvestModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {


    private val _today = MutableStateFlow<String>("")
    val today: MutableStateFlow<String> = _today

    private val _investingBalance = MutableStateFlow<String>("")
    val investingBalance: MutableStateFlow<String> = _investingBalance

    private val _investmentList = MutableStateFlow<List<InvestModel>?>(emptyList())
    val investmentList: StateFlow<List<InvestModel>?> = _investmentList

    init {
        fetchTodayDay()
        fetchInvestingBalance()
        fetchInvestments()
    }

    fun fetchInvestments() {
        _investmentList.value = null
        viewModelScope.launch {
            delay(1500)
            _investmentList.value = InvestRepository().getInvestments()
        }
    }

    fun fetchInvestingBalance() {
        investingBalance.value = "23.432,50"
    }

    fun fetchTodayDay() {
        today.value = "12 Şubat Salı"
    }
}