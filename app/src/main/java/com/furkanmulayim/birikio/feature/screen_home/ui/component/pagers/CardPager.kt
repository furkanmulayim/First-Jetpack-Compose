package com.furkanmulayim.birikio.feature.screen_home.ui.component.pagers


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.theme.Appsize

@Composable
fun CardPager(
) {
    Box(
        modifier = Modifier
            .padding(top = Appsize.padding20)
            .fillMaxWidth()
            .height(Appsize.balancePagerSize)
            .padding(horizontal = Appsize.padding20)
            .clip(RoundedCornerShape(Appsize.radius12))
            .background(colorScheme.primaryContainer), contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.svg_dark_balance),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

    }
}