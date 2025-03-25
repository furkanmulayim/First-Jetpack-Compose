package com.furkanmulayim.golden.presentation.investing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.furkanmulayim.golden.core.component.others.CustomTopBarWidget
import com.furkanmulayim.golden.core.component.others.LocalAppNavController
import com.furkanmulayim.golden.presentation.BaseScreen

@Composable
fun InvestingScreen(
    navController: NavController, bundle: String
) {
    CompositionLocalProvider(LocalAppNavController provides navController) {
        BaseScreen {
            InvestingContent(
                backName = bundle
            )
        }
    }
}

@Composable
private fun InvestingContent(
    backName: String
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CustomTopBarWidget(
            backName = backName,
            leadingClick = {})
    }
}