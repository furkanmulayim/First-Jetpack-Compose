package com.furkanmulayim.birikio.feature.screen_profile.ui.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.theme.button
import com.furkanmulayim.birikio.design.theme.soldedLight


@Composable
fun CustomSwitch(
    isChecked: Boolean,
    isLanguage: Boolean? = false,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val transition = updateTransition(targetState = isChecked, label = "SwitchTransition")

    val backgroundColor by transition.animateColor(label = "") { checked ->
        if (checked) colorScheme.primary else colorScheme.surfaceVariant
    }

    val flagBackgroundColor by transition.animateColor(label = "") { checked ->
        if (checked) soldedLight else button
    }


    val alignment by transition.animateDp(label = "CirclePosition") { checked ->
        if (checked) 22.dp else 2.dp
    }
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = modifier
            .width(50.dp)
            .height(30.dp)
            .clip(RoundedCornerShape(50))
            .background(if (isLanguage == false) backgroundColor else flagBackgroundColor)
            .clickable(
                interactionSource = interactionSource,
                indication = ripple(bounded = false, radius = 0.dp)
            ) { onCheckedChange(!isChecked) }, contentAlignment = Alignment.CenterStart
    ) {
        Box(
            modifier = Modifier
                .padding(start = alignment)
                .size(25.dp)
                .background(Color.White, shape = CircleShape)
        ) {

            if (isLanguage == true) {
                Image(
                    painter = painterResource(if (isChecked) R.drawable.flag_tr else R.drawable.flag_en),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
            }
        }
    }
}