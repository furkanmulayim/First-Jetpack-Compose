package com.furkanmulayim.birikio.ui.tab_pages.tab_wallet_ui.viewmodel

import androidx.lifecycle.ViewModel
import com.furkanmulayim.birikio.data.repository.InvestRepository
import com.furkanmulayim.birikio.model.InvestModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WalletViewModel : ViewModel() {

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