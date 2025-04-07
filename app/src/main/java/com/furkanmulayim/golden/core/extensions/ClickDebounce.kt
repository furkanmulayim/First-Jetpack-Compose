package com.furkanmulayim.golden.core.extensions

import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

private var lastClickTime = 0L

// don't double click :')
fun (() -> Unit).debounced(delayMillis: Long = 600): () -> Unit {
    return {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime >= delayMillis) {
            lastClickTime = currentTime
            this()
        }
    }
}

fun Modifier.debounceClickable(
    debounceInterval: Long = 600L, onClick: () -> Unit
): Modifier = composed {
    var lastClickTime by remember { mutableLongStateOf(0L) }

    this.clickable {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime >= debounceInterval) {
            lastClickTime = currentTime
            onClick()
        }
    }
}