package com.furkanmulayim.golden.presentation.investing

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.furkanmulayim.golden.presentation.BaseScreen


@Composable
fun InvestingScreen(
    navController: NavController, bundle: String
) {
    BaseScreen {
        InvestingContent(
            navController = navController
        )
    }
}

@Composable
private fun InvestingContent(
    navController: NavController
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

    }
}