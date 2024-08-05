package com.soten.movieticketing.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.soten.movieticketing.ui.home.HomeRoute

const val movieNavigationRoute = "movie_route"

fun NavController.navigateMovie(navOptions: NavOptions? = null) {
    this.navigate(movieNavigationRoute, navOptions)
}

interface HomeNavigator {
    fun navigateDetail(id: String)
}

fun NavGraphBuilder.homeScreen(
    homeNavigator: HomeNavigator,
) {
    composable(route = movieNavigationRoute) {
        HomeRoute(homeNavigator)
    }
}