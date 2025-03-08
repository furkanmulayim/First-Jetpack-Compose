import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.furkanmulayim.golden.navigation.AppScreens
import com.furkanmulayim.golden.ui.BaseScreen
import com.furkanmulayim.golden.ui.home_screen.widgets.BurgerBarSection
import com.furkanmulayim.golden.ui.home_screen.widgets.InvestingBalanceSection

@Composable
fun HomeScreen(navController: NavController) {
    BaseScreen {
        BurgerBarSection()
        InvestingBalanceSection(
            totalInvesting = "3.412,50"
        )
        PrimaryButtonSection(leftOnClick = {
            navController.navigate(AppScreens.InvestingScreen.go("main"))
        }, rightOnClick = {})
        // ChartsSection
        // LastInvestingSection
    }
}