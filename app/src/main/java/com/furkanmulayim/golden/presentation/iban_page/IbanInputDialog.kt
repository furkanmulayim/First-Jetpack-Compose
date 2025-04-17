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
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.furkanmulayim.golden.core.extensions.IbanVisualTransformation
import com.furkanmulayim.golden.presentation.theme.AppSize
import com.furkanmulayim.golden.presentation.theme.Typo
import com.furkanmulayim.golden.presentation.theme.textTwins
import com.furkanmulayim.golden.presentation.theme.twins_40


@Composable
fun IbanInputDialog(
    onDismiss: () -> Unit, onSave: (String) -> Unit
) {
    var rawIban by remember { mutableStateOf("") }
    var nameIban by remember { mutableStateOf("") }
    val maxLength = 24
    val isSuccess = rawIban.length == maxLength && nameIban.isNotEmpty()

    Dialog(onDismissRequest = { onDismiss() }) {
        Surface(
            shape = RoundedCornerShape(16.dp), color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .padding(AppSize.Padding)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "IBAN Ekle", modifier = Modifier.padding(
                        top = AppSize.PaddingMedium, bottom = AppSize.PaddingSmall
                    ), color = textTwins, style = Typo.font_19_w300
                )

                BasicTextFieldCustom(
                    value = rawIban, onValueChange = { rawIban = it }, isIban = true
                )

                BasicTextFieldCustom(
                    value = nameIban, onValueChange = { nameIban = it }, isIban = false
                )
                Row(
                    modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(AppSize.RadiusMedium))
                            .background(color = if (isSuccess) MaterialTheme.colorScheme.onSecondaryContainer else twins_40),
                        onClick = { onSave(rawIban) },
                        enabled = isSuccess
                    ) {
                        Text(
                            "Kaydet",
                            color = if (isSuccess) MaterialTheme.colorScheme.secondary else Color.Gray
                        )
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
        singleLine = true,

        textStyle = Typo.font_16_w500.copy(color = MaterialTheme.colorScheme.onSecondaryContainer),
        onValueChange = {
            if (isIban) {
                val digits = it.filter { ch -> ch.isDigit() }.take(24)
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
        keyboardOptions = KeyboardOptions(
            keyboardType = if (isIban) KeyboardType.Number else KeyboardType.Text
        ),
        visualTransformation = if (isIban) IbanVisualTransformation() else VisualTransformation.None,
        decorationBox = { innerTextField ->
            Box {
                if (value.isEmpty()) {
                    Text(
                        if (isIban) "IBAN" else "İsim", color = textTwins, style = Typo.font_16_w300
                    )
                }
                innerTextField()
            }
        })
}