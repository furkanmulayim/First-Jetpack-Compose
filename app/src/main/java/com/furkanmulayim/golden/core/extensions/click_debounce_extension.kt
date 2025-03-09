package com.furkanmulayim.golden.core.extensions

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
