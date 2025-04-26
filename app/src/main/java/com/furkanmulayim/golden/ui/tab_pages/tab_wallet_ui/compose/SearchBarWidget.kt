package com.furkanmulayim.golden.ui.tab_pages.tab_wallet_ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    val searchText = remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color(0xFFF2F4F7), shape = RoundedCornerShape(24.dp))
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        if (searchText.value.isEmpty()) {
            Row(verticalAlignment = Alignment.CenterVertically) {
//                Icon(
//                    active = TODO(),
//                    activeContent = TODO(),
//                    inactiveContent = TODO()
//                )
                Spacer(modifier = Modifier.width(8.dp))

                val annotatedString = buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.Gray)) {
                        append("Try ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray,
                        )
                    ) {
                        append("“amazon”")
                    }
                }

                Text(text = annotatedString)
            }
        }

        BasicTextField(
            value = searchText.value,
            onValueChange = { searchText.value = it },
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}