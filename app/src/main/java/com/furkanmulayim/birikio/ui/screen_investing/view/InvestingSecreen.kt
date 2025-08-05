package com.furkanmulayim.birikio.ui.screen_investing.view

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.furkanmulayim.birikio.ui.screen_investing.viewmodel.HomeViewModel

@Composable
fun InvestingScreen(
    navController: NavController, viewModel: HomeViewModel = viewModel()
) {

    InvestingContent(
        navController = navController, viewModel
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InvestingContent(
    navController: NavController, viewModel: HomeViewModel
) {
    CenterAlignedTopAppBar(title = { Text("Furkan") }, navigationIcon = {

    }

    )
}
