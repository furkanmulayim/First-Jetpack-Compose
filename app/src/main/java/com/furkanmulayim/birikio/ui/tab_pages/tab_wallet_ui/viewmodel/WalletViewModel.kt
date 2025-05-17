package com.furkanmulayim.birikio.ui.tab_pages.tab_wallet_ui.viewmodel

import androidx.lifecycle.ViewModel
import com.furkanmulayim.birikio.data.repository.WalletRepository
import com.furkanmulayim.birikio.model.WalletModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WalletViewModel : ViewModel() {

    private val _investingBalance = MutableStateFlow<String>("")
    val investingBalance: MutableStateFlow<String> = _investingBalance

    private val _investmentList = MutableStateFlow<List<WalletModel>?>(emptyList())
    val investmentList: StateFlow<List<WalletModel>?> = _investmentList


    init {
        fetchInvestingBalance()
        fetchInvestments()
    }

    fun fetchInvestments() {
        _investmentList.value = WalletRepository().getWallet()
    }

    fun fetchInvestingBalance() {
        investingBalance.value = "11.783,22"
    }


}