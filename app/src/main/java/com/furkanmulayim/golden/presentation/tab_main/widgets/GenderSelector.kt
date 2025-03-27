package com.furkanmulayim.golden.presentation.tab_main.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.furkanmulayim.golden.core.component.others.CustomSpacerWidth
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.CustomTypo

@Composable
fun GenderSelector(
    selectedIndex: Int, onSelectionChanged: (Int) -> Unit
) {
    val selectedColor = MaterialTheme.colorScheme.onSurface
    val unSelectedColor = MaterialTheme.colorScheme.surface

    var denek = "Yatırımlarım"
    var denek2 = "Cüzdanım"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            if (selectedIndex == 0) denek else denek2,
            style = CustomTypo.text.bodyLarge.copy(selectedColor)
        )

        Row(
            modifier = Modifier
                .padding(top = 4.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            listOf(0, 1).forEach { index ->
                Box(
                    modifier = Modifier
                        .height(AppSize.PaddingXSmall)
                        .width(AppSize.PaddingXLarge)
                        .clip(RoundedCornerShape(50))
                        .background(if (index == selectedIndex) selectedColor else unSelectedColor)
                        .clickable { onSelectionChanged(index) })
                if (index == 0) {
                    CustomSpacerWidth(8)
                }
            }
        }
    }
}