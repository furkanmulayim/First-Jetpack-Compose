package com.furkanmulayim.golden.core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.others.CustomSpacerHeight
import com.furkanmulayim.golden.models.InvestModel
import com.furkanmulayim.golden.presentation.home.widgets.InvestListItemWidget
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.CustomTypo


//LİST SECTION
@Composable
fun InvestmentList(list: List<InvestModel>?) {
    val historyListText = stringResource(id = R.string.history_list)
    Text(
        text = historyListText,
        style = CustomTypo.text.labelLarge.copy(color = MaterialTheme.colorScheme.tertiary),
    )
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
    /** todo Eğer liste boş ise buraya yazılacak. */
}

@Composable
fun StateIsLoading() {
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.size(AppSize.ButtonHeight))
    }
}

// IF SUCCES STATE
@Composable
fun StateIsSuccess(list: List<InvestModel>) {
    LazyColumn(
        modifier = Modifier
            .padding(bottom = 48.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(AppSize.RadiusButtons))
            .background(MaterialTheme.colorScheme.surface)
    ) {
        items(list) { investment ->
            InvestListItemWidget(investment, onClick = {})
        }
    }
}

