import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.furkanmulayim.golden.R

@Composable
fun BackgroundImage() {
    val isDarkTheme = isSystemInDarkTheme()

    val backgroundImage = if (isDarkTheme) {
        painterResource(id = R.drawable.background_dark)
    } else {
        painterResource(id = R.drawable.background_light)
    }

    Image(
        painter = backgroundImage,
        contentDescription = "Background Image",
        contentScale = ContentScale.Crop, // Tam ekran kaplasın
        modifier = Modifier
            .fillMaxSize()
    )
}