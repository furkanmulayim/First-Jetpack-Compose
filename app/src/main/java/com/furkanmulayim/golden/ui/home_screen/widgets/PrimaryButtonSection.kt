import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.furkanmulayim.golden.R
import com.furkanmulayim.golden.core.constants.component.SpacedWidth
import com.furkanmulayim.golden.ui.theme.AppSize
import com.furkanmulayim.golden.ui.theme.CustomTypo

@Composable
fun PrimaryButtonSection(
    leftOnClick: () -> Unit,
    rightOnClick: () -> Unit
) {
    val doInvest = stringResource(id = R.string.do_investing)
    val liveData = stringResource(id = R.string.live_data)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = AppSize.PaddingMedium),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // BUTTON -> DO INVEST BUTTON
        CustomButton(
            modifier = Modifier.weight(1f),
            text = doInvest,
            backgroundColor = MaterialTheme.colorScheme.secondary,
            textColor = MaterialTheme.colorScheme.onSecondary,
            iconRes = R.drawable.svg_wallet_money,
            onClick = leftOnClick // Düzeltildi
        )
        SpacedWidth(10)

        // BUTTON -> LIVE DATA
        CustomButton(
            modifier = Modifier.weight(1f),
            text = liveData,
            backgroundColor = MaterialTheme.colorScheme.primary,
            textColor = MaterialTheme.colorScheme.onPrimary,
            iconRes = R.drawable.svg_live_data, // SVG ikonun drawable'daki adı
            onClick = rightOnClick // Düzeltildi
        )
    }
}

// CUSTOM BUTTONS
@Composable
private fun CustomButton(
    text: String,
    backgroundColor: Color,
    textColor: Color,
    iconRes: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        shape = RoundedCornerShape(AppSize.RadiusMedium),
        modifier = modifier.height(AppSize.ButtonHeight)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = text,
                tint = textColor,
                modifier = Modifier.size(AppSize.ButtonSmallHeight)
            )
            SpacedWidth(8)
            Text(
                text = text, style = CustomTypo.text.bodySmall
            )
        }
    }
}
