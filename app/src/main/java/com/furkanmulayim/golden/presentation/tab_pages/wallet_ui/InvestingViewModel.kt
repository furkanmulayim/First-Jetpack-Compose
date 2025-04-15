package com.furkanmulayim.golden.presentation.tab_pages.wallet_ui

import androidx.lifecycle.ViewModel
import com.furkanmulayim.golden.data.repository.InvestRepository
import com.furkanmulayim.golden.models.InvestModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InvestingViewModel : ViewModel() {

    private val _investingBalance = MutableStateFlow<String>("")
    val investingBalance: MutableStateFlow<String> = _investingBalance

    private val _investmentList = MutableStateFlow<List<InvestModel>?>(emptyList())
    val investmentList: StateFlow<List<InvestModel>?> = _investmentList


    init {
        fetchInvestingBalance()
        fetchInvestments()
    }

    fun fetchInvestments() {
        _investmentList.value = InvestRepository().getInvestments()
    }

    fun fetchInvestingBalance() {
        investingBalance.value = "11.783,22"
    }


}