import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.birikio.design.theme.Appsize


@Composable
fun CustomIconButton(icon: Int, onClick: () -> Unit, isProfile: Boolean = false) {
    val size = Appsize
    Box(
        Modifier
            .clip(RoundedCornerShape(if (isProfile) size.radius100 else size.radius12))
            .size(if (isProfile) size.profileButtonSize else size.iconButtonSize)
            .background(if (isProfile) colorScheme.onPrimaryContainer else colorScheme.primaryContainer)
            .clickable { onClick() }
            .padding(size.padding8),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painterResource(icon),
            tint = if (isProfile) Color.Unspecified else colorScheme.primary,
            contentDescription = "menu",
        )
    }
}