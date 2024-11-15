package com.gymshark.hits.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType


import com.gymshark.hits.screens.detail.DetailScreen
import com.gymshark.hits.screens.home.MainScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.gymshark.hits.screens.SharedViewModel
import com.gymshark.screens.splash.GymSharkSplashScreen



@Composable
fun HitsNavigationHost(navController: NavHostController, viewModel: SharedViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash.name
    ) {
        composable(Screens.Splash.name) {
            GymSharkSplashScreen(navController)
        }
        composable(Screens.MainScreen.name) {
            //val mainScreenViewModel = hiltViewModel<MainScreenViewModel>()
            MainScreen(navController,viewModel)
        }
        composable(Screens.DetailScreen.name + "/{hit}",
            arguments = listOf(navArgument(name ="hit") {type = NavType.IntType})) {
            it.arguments?.getInt("hit")?.let { it1 -> DetailScreen(navController, it1,viewModel) }
        }

    }
}