package com.furkanmulayim.birikio.feature.sheet_buy_sold.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.furkanmulayim.birikio.design.theme.Appsize
import com.furkanmulayim.birikio.design.theme.Typo
import com.furkanmulayim.birikio.design.theme.primaryContainer

@Composable
fun CustomTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    enabled: Boolean = true,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Appsize.padding12)
            .background(primaryContainer, RoundedCornerShape(Appsize.radius16))
            .padding(Appsize.padding6), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(horizontal = Appsize.padding20),
            text = label,
            style = Typo.font_16_w400
        )

        BasicTextField(
            value = value,
            onValueChange = { input ->
                onValueChange(input.filter { it.isDigit() })
            },
            enabled = enabled,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = Typo.font_16_w400.copy(
                textAlign = TextAlign.Center
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .weight(1f)
                .onFocusChanged { focusState ->
                    if (focusState.isFocused && value.isNotEmpty()) {
                        onValueChange("")
                    }
                }) { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Appsize.iconButtonSize)
                    .background(Color.White, RoundedCornerShape(Appsize.radius12)),
                contentAlignment = Alignment.Center
            ) {
                innerTextField()
            }
        }
    }
}