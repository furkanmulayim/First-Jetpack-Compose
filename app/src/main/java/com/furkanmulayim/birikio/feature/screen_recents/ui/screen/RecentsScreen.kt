package com.furkanmulayim.birikio.feature.screen_recents.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.furkanmulayim.birikio.R
import com.furkanmulayim.birikio.design.component.app_bar.AppBarSection
import com.furkanmulayim.birikio.design.component.page.CustomScaffold
import com.furkanmulayim.birikio.design.theme.Appsize

@Composable
fun RecentsScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorScheme.surfaceVariant)
            .padding(top = Appsize.padding64)
    ) {
        AppBarSection(
            name = stringResource(R.string.nameRecents),
            onBackClick = { navController.popBackStack() })

        CustomScaffold { }
    }
}
