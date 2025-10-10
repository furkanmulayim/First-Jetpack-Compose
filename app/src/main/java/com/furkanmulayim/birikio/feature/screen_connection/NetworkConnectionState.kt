package com.furkanmulayim.birikio.feature.screen_connection

import android.Manifest
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import androidx.annotation.RequiresPermission
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.distinctUntilChanged

sealed interface NetworkConnectionState {
    data object Available : NetworkConnectionState
    data object Unavailable : NetworkConnectionState
}

private fun networkCallback(
    cm: ConnectivityManager,
    emit: (NetworkConnectionState) -> Unit,
): ConnectivityManager.NetworkCallback = object : ConnectivityManager.NetworkCallback() {

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    private fun current(): NetworkConnectionState {
        val network = cm.activeNetwork ?: return NetworkConnectionState.Unavailable
        val caps = cm.getNetworkCapabilities(network) ?: return NetworkConnectionState.Unavailable
        val hasInternet = caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        // VALIDATED (varsa) gerçekten dış ağa çıkabildiğini gösterir
        val validated = caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        return if (hasInternet && validated) NetworkConnectionState.Available
        else NetworkConnectionState.Unavailable
    }

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    override fun onAvailable(network: Network) {
        emit(current())
    }

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    override fun onLost(network: Network) {
        emit(current())
    }

    @RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
    override fun onCapabilitiesChanged(
        network: Network,
        networkCapabilities: NetworkCapabilities,
    ) {
        emit(current())
    }

    override fun onUnavailable() {
        emit(NetworkConnectionState.Unavailable)
    }
}

@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun getCurrentConnectivityState(connectivityManager: ConnectivityManager): NetworkConnectionState {
    val network = connectivityManager.activeNetwork ?: return NetworkConnectionState.Unavailable
    val caps = connectivityManager.getNetworkCapabilities(network)
        ?: return NetworkConnectionState.Unavailable
    val hasInternet = caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    val validated = caps.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
    return if (hasInternet && validated) NetworkConnectionState.Available
    else NetworkConnectionState.Unavailable
}

@RequiresPermission(Manifest.permission.ACCESS_NETWORK_STATE)
fun Context.observeConnectivityAsFlow(): Flow<NetworkConnectionState> = callbackFlow {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    // İlk değeri anında gönder
    trySend(getCurrentConnectivityState(cm))

    val cb = networkCallback(cm) { state ->
        trySend(state).isSuccess
    }

    cm.registerDefaultNetworkCallback(cb)

    awaitClose {
        cm.unregisterNetworkCallback(cb)
    }
}.distinctUntilChanged()

