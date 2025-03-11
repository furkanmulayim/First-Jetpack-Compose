import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.component.CustomSpacerHeight
import com.furkanmulayim.golden.core.component.CustomSpacerWidth
import com.furkanmulayim.golden.core.component.buttons.default_buttons.CustomSecondaryButton
import com.furkanmulayim.golden.ui.theme.AppSize

@Composable
fun ButtonSection(
    doIncestingOnClick: () -> Unit, exchangeRateOnClick: () -> Unit
) {
    val doInvestText = stringResource(id = R.string.do_investing)
    val exchangeRateText = stringResource(id = R.string.exchange_rate)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = AppSize.PaddingMedium),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // BUTTON -> DO INVEST BUTTON
        CustomSecondaryButton(
            modifier = Modifier.weight(1f),
            text = doInvestText,
            iconRes = R.drawable.svg_investings,
            onClick = doIncestingOnClick
        )
        CustomSpacerWidth(10)

        // BUTTON -> LIVE DATA
        CustomSecondaryButton(
            modifier = Modifier.weight(1f),
            text = exchangeRateText,
            iconRes = R.drawable.svg_live_data,
            onClick = exchangeRateOnClick
        )
    }
    CustomSpacerHeight(32)
}

