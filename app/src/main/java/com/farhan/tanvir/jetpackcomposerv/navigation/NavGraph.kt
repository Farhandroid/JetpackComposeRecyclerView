package com.farhan.tanvir.jetpackcomposerv.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.farhan.tanvir.jetpackcomposerv.presentation.screen.details.MovieDetailsScreen
import com.farhan.tanvir.jetpackcomposerv.presentation.screen.home.HomeScreen
import com.farhan.tanvir.jetpackcomposerv.util.Constant


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.MovieDetails.route,
            arguments = listOf(navArgument(Constant.MOVIE_DETAILS_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(Constant.MOVIE_DETAILS_ARGUMENT_KEY)
                ?.let { MovieDetailsScreen(it) }
        }
    }
}