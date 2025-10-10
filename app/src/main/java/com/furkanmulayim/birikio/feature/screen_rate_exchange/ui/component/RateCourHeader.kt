package com.furkanmulayim.birikio.feature.screen_rate_exchange.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import kotlinx.coroutines.flow.StateFlow


@Composable
fun RateCourHeader(date: StateFlow<String>, onRefreshClick: () -> Unit) {

    Column(
        modifier = Modifier
            .padding(top = Appsize.padding28, start = Appsize.padding8)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(start = Appsize.size4),
            text = stringResource(R.string.nameRate),
            style = Typo.font_19_w800
        )
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(Appsize.radius16))
                .clickable {
                    onRefreshClick()
                }
                .padding(horizontal = Appsize.radius4),
            verticalAlignment = Alignment.CenterVertically) {
            Text(
                modifier = Modifier.fillMaxHeight(),
                text = date.collectAsState().value,
                style = Typo.font_15_w500,
            )
            Icon(
                painter = painterResource(R.drawable.balance_button_history),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(Appsize.iconSize24)
                    .padding(start = Appsize.padding8)
            )
        }


    }

}