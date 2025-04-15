package com.furkanmulayim.golden.presentation.iban_page


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.furkanmulayim.golden.core.extensions.IbanVisualTransformation
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.Typo
import com.furkanmulayim.golden.presentation.theme.twins_40


@Composable
fun IbanInputDialog(
    onDismiss: () -> Unit, onSave: (String) -> Unit
) {
    var rawIban by remember { mutableStateOf("") }
    var nameIban by remember { mutableStateOf("") }
    val maxLength = 22
    val isSuccess = rawIban.length == maxLength && nameIban.isNotEmpty()

    Dialog(onDismissRequest = { onDismiss() }) {
        Surface(
            shape = RoundedCornerShape(16.dp), color = Color.White
        ) {
            Column(
                modifier = Modifier
                    .padding(24.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    "IBAN Ekle",
                    modifier = Modifier.padding(
                        top = AppSize.PaddingSmall,
                        bottom = AppSize.PaddingXSmall
                    ),
                    color = Color.Gray,
                    style = Typo.font_16_w500
                )

                BasicTextFieldCustom(
                    value = rawIban, onValueChange = { rawIban = it }, isIban = true
                )

                BasicTextFieldCustom(
                    value = nameIban, onValueChange = { nameIban = it }, isIban = false
                )
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("İptal")
                    }
                    TextButton(
                        onClick = { onSave(rawIban) }, enabled = isSuccess
                    ) {
                        Text("Kaydet")
                    }
                }
            }
        }
    }
}

@Composable
private fun BasicTextFieldCustom(
    value: String, onValueChange: (String) -> Unit, isIban: Boolean
) {
    BasicTextField(
        value = value,
        textStyle = Typo.font_16_w500,
        onValueChange = {
            if (isIban) {
                val digits = it.filter { ch -> ch.isDigit() }.take(22)
                onValueChange(digits)
            } else {
                onValueChange(it)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Color.Transparent, shape = RoundedCornerShape(AppSize.RadiusMedium)
            )
            .border(
                width = 0.5.dp, color = twins_40, shape = RoundedCornerShape(AppSize.RadiusMedium)
            )
            .padding(16.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        visualTransformation = if (isIban) IbanVisualTransformation() else VisualTransformation.None,
        decorationBox = { innerTextField ->
            Box {
                if (value.isEmpty()) {
                    Text(
                        if (isIban) "IBAN" else "İsim",
                        color = Color.Gray,
                        style = Typo.font_16_w500
                    )
                }
                innerTextField()
            }
        })
}