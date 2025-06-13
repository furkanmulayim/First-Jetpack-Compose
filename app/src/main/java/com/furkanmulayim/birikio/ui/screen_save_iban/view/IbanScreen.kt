package com.furkanmulayim.birikio.ui.screen_save_iban.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.core.component.buttons.icon_button.CustomIconTextButton
import com.furkanmulayim.birikio.ui.screen_save_iban.compose.IbanInputDialog
import com.furkanmulayim.birikio.ui.theme.AppSize
import com.furkanmulayim.birikio.ui.theme.Typo
import com.furkanmulayim.birikio.ui.theme.textTwins

@Composable
fun IbanScreen(navController: NavHostController) {
    IbanContent(navController)
}

@Composable
private fun IbanContent(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = AppSize.PaddingLarge)
    ) {
        // Üstteki geri butonu
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = AppSize.PaddingXLarge)
                .height(AppSize.ButtonHeight),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomIconTextButton(
                icon = R.drawable.svg_icon_arrow_left, onClick = {
                    navController.popBackStack()
                }, text = "Geri"
            )

            CustomIconTextButton(
                icon = R.drawable.svg_square_icon_tick,
                onClick = { showDialog = true },
                text = "IBAN Ekle",
                isRightIcon = true
            )
        }

        // Alt içerik (IBAN ekleme vs)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = AppSize.PaddingXLarge + AppSize.PaddingLarge + AppSize.ButtonHeight),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            EmptyIbanList()

            if (showDialog) {
                IbanInputDialog(onDismiss = { showDialog = false }, onSave = { iban ->
                    println("Kaydedilen IBAN: $iban")
                    showDialog = false
                })
            }
        }
    }
}

@Composable
fun EmptyIbanList() {
    Image(
        painter = painterResource(id = R.drawable.png_iban_image),
        contentDescription = "Iban Image",
        modifier = Modifier
            .width(AppSize.ItemImage)
            .padding(bottom = AppSize.PaddingSmall),
        contentScale = ContentScale.FillBounds
    )
    Text(
        "Önce Lütfen Sağ Üstte Bulunan Butondan IBAN ekleyiniz.",
        style = Typo.font_14_w500,
        color = textTwins,
        textAlign = TextAlign.Center
    )
}