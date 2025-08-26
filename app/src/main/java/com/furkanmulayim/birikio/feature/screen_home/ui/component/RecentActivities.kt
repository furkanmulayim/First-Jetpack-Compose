package com.furkanmulayim.birikio.feature.screen_home.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import com.furkanmulayim.birikio.design.theme.transparent40
import com.furkanmulayim.birikio.feature.screen_home.data.model.RecentTransaction


@Composable
fun RecentActivities(isShowButtonVisible: Boolean) {

    CustomSpacerHeight(Appsize.padding20)

    val topRadius = RoundedCornerShape(topStart = Appsize.radius12, topEnd = Appsize.radius12)

    Column(
        modifier = Modifier
            .padding(horizontal = Appsize.padding20)
            .fillMaxWidth()
            .clip(topRadius)
            .background(colorScheme.primaryContainer)
            .border(0.2.dp, transparent40, topRadius)
            .padding(horizontal = Appsize.padding12, vertical = Appsize.padding8),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            Box(
                modifier = Modifier
                    .size(Appsize.iconButtonSize)
                    .padding(Appsize.padding6)
                    .clip(RoundedCornerShape(Appsize.radius4))
                    .background(colorScheme.secondaryContainer)
                    .padding(Appsize.padding6),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(R.drawable.svg_recent_activity),
                    contentDescription = null
                )
            }

            Text("Son İşlemlerim", style = Typo.font_15_w600)

            Spacer(Modifier.weight(1f))

            if (isShowButtonVisible) Text(
                "Gör",
                style = Typo.font_12_w500.copy(colorScheme.primary),
                modifier = Modifier
                    .clip(RoundedCornerShape(Appsize.radius8))
                    .clickable(enabled = isShowButtonVisible) { /* TODO onClick */ }
                    .border(Appsize.size1, colorScheme.primary, RoundedCornerShape(Appsize.radius8))
                    .padding(Appsize.size4))

        }
    }
    if (!isShowButtonVisible) EmptyList() else RecentTransactionList(fakeRecentTransactions())
}

@Composable
private fun EmptyList() {
    val bottomRadius =
        RoundedCornerShape(bottomStart = Appsize.radius12, bottomEnd = Appsize.radius12)

    Column(
        modifier = Modifier
            .padding(horizontal = Appsize.padding20)
            .fillMaxWidth()
            .clip(bottomRadius)
            .background(colorScheme.primaryContainer)
            .border(0.2.dp, transparent40, bottomRadius)
            .padding(horizontal = Appsize.padding12, vertical = Appsize.padding8),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.empty_list),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(100.dp)
                .padding(vertical = Appsize.padding12)
        )

        Text(
            text = "Herhangi bir işlem yapmadınız",
            style = Typo.font_15_w600.copy(
                color = colorScheme.secondary,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = Appsize.padding8)
        )

        Text(
            text = "Varlıklarım menüsünden işlem yapmanız gerekiyor.",
            style = Typo.font_12_w500.copy(
                color = colorScheme.secondary,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Appsize.padding8)
        )
    }
}

private fun fakeRecentTransactions(): List<RecentTransaction> = listOf(
    RecentTransaction(
        id = 1,
        name = "Dolar",
        date = "12 Temmuz 2025",
        count = 100.0,
        amount = 32.0,
        total = 3200.0,
        icon = R.drawable.money_dollar,
        isSold = true
    ),
    RecentTransaction(
        id = 2,
        name = "Çeyrek",
        date = "12 Temmuz 2025",
        count = 4.0,
        amount = 6400.0,
        total = 25600.0,
        icon = R.drawable.money_ceyrek,
        isSold = false
    ),
    RecentTransaction(
        id = 3,
        name = "Euro",
        date = "12 Temmuz 2025",
        count = 1.0,
        amount = 350.0,
        total = 350.0,
        icon = R.drawable.money_euro,
        isSold = false
    ),
)

@SuppressLint("DefaultLocale")
@Composable
fun RecentTransactionItem(item: RecentTransaction) {
    val total = item.count * item.amount

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = item.name,
            modifier = Modifier.size(44.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.name, style = Typo.font_15_w600
            )
            Text(
                text = item.date, style = Typo.font_12_w700.copy(color = colorScheme.secondary)
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            // Toplam fiyat (count * amount)
            Text(
                text = "${String.format("%,.2f", total)}₺", style = Typo.font_15_w600.copy(
                    color = if (item.isSold) Color(0xFFE53935) else Color(0xFF1E88E5)
                )
            )
            // Alt bilgi
            Text(
                text = "${item.count.toInt()} x ${String.format("%,.2f", item.amount)}₺",
                style = Typo.font_12_w700.copy(color = colorScheme.secondary)
            )
        }
    }
}

@Composable
fun RecentTransactionList(transactions: List<RecentTransaction>) {


    val bottomRadius =
        RoundedCornerShape(bottomStart = Appsize.radius12, bottomEnd = Appsize.radius12)
    androidx.compose.foundation.lazy.LazyColumn(
        modifier = Modifier
            .padding(horizontal = Appsize.padding20)
            .fillMaxWidth()
            .clip(bottomRadius)
            .background(colorScheme.primaryContainer)
            .border(0.2.dp, transparent40, bottomRadius)
            .padding(horizontal = Appsize.padding12, vertical = Appsize.padding8),
    ) {
        items(transactions) { transaction ->
            RecentTransactionItem(transaction)
        }
    }
}