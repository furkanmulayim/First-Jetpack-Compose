package com.furkanmulayim.birikio.core.state

sealed class GoldUiState<out T> {
    object Loading : GoldUiState<Nothing>()
    data class Success<T>(val data: T) : GoldUiState<T>()
    data class Error(val message: String?) : GoldUiState<Nothing>()
}