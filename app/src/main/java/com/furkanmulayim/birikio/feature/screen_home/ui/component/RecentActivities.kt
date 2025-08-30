package com.furkanmulayim.birikio.feature.screen_home.ui.component

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.others.CustomHorizontalDivider
import com.furkanmulayim.birikio.design.component.others.CustomSpacerHeight
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import com.furkanmulayim.birikio.design.theme.primaryContainer
import com.furkanmulayim.birikio.design.theme.solded
import com.furkanmulayim.birikio.feature.screen_home.data.model.RecentTransaction
import java.util.Locale

@Composable
fun RecentActivities(isShowButtonVisible: Boolean) {
    CustomSpacerHeight(Appsize.padding20)

    SectionCard {
        if (isShowButtonVisible) {
            SectionHeader(onClick = { /* TODO */ })
            RecentTransactionList(fakeRecentTransactions())
        } else {
            EmptyState()
        }
    }
}


@Composable
private fun SectionCard(content: @Composable ColumnScope.() -> Unit) {
    val shape = RoundedCornerShape(Appsize.radius16)
    Column(
        modifier = Modifier
            .padding(horizontal = Appsize.padding20)
            .fillMaxWidth()
            .clip(shape)
            .background(colorScheme.primaryContainer)
            .border(0.5.dp, colorScheme.outline, shape)
            .padding(horizontal = Appsize.padding12, vertical = Appsize.padding8), content = content
    )
}

@Composable
private fun SectionHeader(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = Appsize.padding12)
            .padding(top = Appsize.padding4),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text("Son İşlemlerim", style = Typo.font_14_w600)

        Spacer(Modifier.weight(1f))

        Text(
            "Tamamını Gör",
            style = Typo.font_12_w500.copy(colorScheme.primary),
            modifier = Modifier
                .clip(RoundedCornerShape(Appsize.radius8))
                .clickable(
                    onClick = onClick,
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() })
                .padding(Appsize.size4)
        )
    }
}

@Composable
private fun EmptyState() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(R.drawable.empty_list),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .height(Appsize.iconSize100)
                .padding(vertical = Appsize.padding12)
        )
        Text(
            text = "Herhangi bir işlem yapmadınız", style = Typo.font_15_w600.copy(
                color = colorScheme.secondary, textAlign = TextAlign.Center
            ), modifier = Modifier
                .fillMaxWidth()
                .padding(top = Appsize.padding8)
        )
        Text(
            text = "Varlıklarım menüsünden işlem yapmanız gerekiyor.",
            style = Typo.font_12_w500.copy(
                color = colorScheme.secondary, textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = Appsize.padding8)
        )
    }
}

@SuppressLint("DefaultLocale")
@Composable
private fun RecentTransactionItem(item: RecentTransaction) {
    val total = item.count * item.amount

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Appsize.padding10, vertical = Appsize.padding6),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            colorFilter = ColorFilter.tint(colorScheme.secondary),
            modifier = Modifier
                .size(Appsize.iconButtonSize)
                .clip(RoundedCornerShape(Appsize.radius12))
                .background(primaryContainer)
        )
        Spacer(Modifier.width(Appsize.padding12))

        Column(Modifier.weight(1f)) {
            Text(item.name, style = Typo.font_15_w500)
            CustomSpacerHeight(Appsize.size3)
            Text(item.date, style = Typo.font_12_w500.copy(color = colorScheme.secondary))
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = total.formatTL(),
                style = Typo.font_15_w600.copy(color = if (item.isSold) solded else colorScheme.primary)
            )
            CustomSpacerHeight(Appsize.size3)
            Text(
                text = "${item.count.toInt()} x ${item.amount.formatTL(noSymbol = true)}",
                style = Typo.font_12_w500.copy(color = colorScheme.secondary)
            )
        }
    }
}

@Composable
private fun RecentTransactionList(transactions: List<RecentTransaction>) {
    CustomSpacerHeight(Appsize.padding8)
    CustomHorizontalDivider()
    CustomSpacerHeight(Appsize.padding8)
    Column {
        transactions.forEach { transaction ->
            RecentTransactionItem(transaction)
        }
    }
}


private fun Double.formatTL(noSymbol: Boolean = false): String {
    val localeTR = Locale.forLanguageTag("tr-TR")
    val s = String.format(localeTR, "%,.2f", this)
    return if (noSymbol) s else "${s}₺"
}


private fun fakeRecentTransactions(): List<RecentTransaction> = listOf(
    RecentTransaction(
        1, "Dolar", "12 Temmuz", 100.0, 32.0, 3200.0, R.drawable.money_dollar, true
    ),
    RecentTransaction(
        2, "Çeyrek", "12 Temmuz", 40.0, 6400.0, 25600.0, R.drawable.money_ceyrek, false
    ),
    RecentTransaction(
        3, "Euro", "12 Temmuz", 144.0, 350.0, 350.0, R.drawable.money_euro, false
    ),
)