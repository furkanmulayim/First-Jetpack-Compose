package com.furkanmulayim.birikio.ui.tab_pages.tab_wallet_ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.model.InvestModel
import com.furkanmulayim.birikio.ui.theme.AppSize
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.twins


//LİST SECTION
@Composable
fun WalletList(list: List<InvestModel>?) {
    CustomSpacerHeight(12)
    when {
        list == null -> StateIsLoading()
        list.isEmpty() -> StateIsEmpty()
        else -> StateIsSuccess(list)
    }
}

// IF EMPTY LIST
@Composable
fun StateIsEmpty() {
    //.padding(horizontal = AppSize.PaddingLarge)
    /** todo Eğer liste boş ise buraya yazılacak. */
}

@Composable
fun StateIsLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppSize.PaddingLarge),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.size(AppSize.ButtonHeight))
    }
}

// IF SUCCES STATE
@Composable
fun StateIsSuccess(list: List<InvestModel>) {

    val headerText = stringResource(id = R.string.last_transaction)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppSize.PaddingLarge),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = headerText,
            style = Typo.font_11_w800.copy(
                color = twins, letterSpacing = 2.sp
            ),
        )
        CustomSpacerHeight(12)
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 64.dp)
                .fillMaxSize()
                .clip(RoundedCornerShape(AppSize.RadiusButtons))
        ) {
            items(list) { investment ->
                WalletListItemWidget(investment, onClick = {})
            }
        }
    }

}

