package com.furkanmulayim.birikio.feature.screen_connection

import android.content.Context
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ConnectivityBanner(
    context: Context = LocalContext.current,
) {
    val state by remember {
        context.observeConnectivityAsFlow()
    }.collectAsState(initial = NetworkConnectionState.Available)

    if (state is NetworkConnectionState.Unavailable) {
        Surface(
            modifier = Modifier,
            color = MaterialTheme.colorScheme.errorContainer,
            tonalElevation = 1.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icons
                androidx.compose.material3.Icon(
                    imageVector = Icons.Filled.WifiOff, contentDescription = null
                )
                androidx.compose.material3.Text(
                    text = "İnternet bağlantısı yok", modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}