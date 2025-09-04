import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.theme.Appsize

@Composable
fun RightArrowOpen() {

    Icon(
        painter = painterResource(
            R.drawable.right_arrow_open
        ),
        tint = Color.Unspecified,
        contentDescription = null,
        modifier = Modifier
            .height(Appsize.iconSize16)
    )

}