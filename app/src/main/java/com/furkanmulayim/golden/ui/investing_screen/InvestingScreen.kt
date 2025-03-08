import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.furkanmulayim.golden.ui.home_screen.widgets.BurgerBarSection
import com.furkanmulayim.golden.ui.theme.AppSize

@Composable
fun InvestingScreen(navController: NavController, invest: String) {
    Scaffold { padding ->

        androidx.compose.foundation.layout.Box(
            modifier = Modifier.fillMaxSize()
        ) {
            BackgroundImage()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = AppSize.PaddingLarge)
            ) {
                BurgerBarSection()
            }
        }
    }
}


