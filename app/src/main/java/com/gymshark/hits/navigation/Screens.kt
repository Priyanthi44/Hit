package com.gymshark.hits.navigation

enum class Screens {
    Splash,
    MainScreen,
    DetailScreen;

    companion object {
        fun fromRoute(route: String): Screens = when (route.substringBefore("/")) {
            MainScreen.name -> MainScreen
            DetailScreen.name -> DetailScreen
            null -> MainScreen
            else -> throw IllegalArgumentException("Route $route is not recognized.")
        }
    }
}