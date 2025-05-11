package com.furkanmulayim.birikio.core.extensions

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class IbanVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = text.text.take(24)

        val formatted = StringBuilder()
        val offsetMap = mutableListOf<Int>()

        var i = 0
        while (i < trimmed.length) {
            formatted.append(trimmed[i])
            offsetMap.add(formatted.length - 1)

            if ((i + 1) % 4 == 0 && i != trimmed.lastIndex) {
                formatted.append(' ')
            }

            i++
        }

        val mapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return offsetMap.getOrElse(offset) { formatted.length }
            }

            override fun transformedToOriginal(offset: Int): Int {
                return offsetMap.indexOfFirst { it >= offset }.takeIf { it >= 0 } ?: trimmed.length
            }
        }

        return TransformedText(AnnotatedString(formatted.toString()), mapping)
    }
}