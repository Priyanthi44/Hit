package com.gymshark.hits.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.gymshark.hits.screens.SharedViewModel

@Composable
fun HitsNavigaton(viewModel: SharedViewModel?) {
    val navController = rememberNavController()
    if (viewModel != null) {
        HitsNavigationHost(navController,viewModel)
    }

}