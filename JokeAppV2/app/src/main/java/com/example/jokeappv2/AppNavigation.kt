package com.example.jokeappv2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jokeappv2.AppDestinations.JOKE_DETAIL_ID_KEY
import com.example.jokeappv2.display.JokesList
import com.example.jokeappv2.display.ListScreen
import com.example.jokeappv2.model.Joke


/**
 * Destinations used in the App.
 */
private object AppDestinations {
    const val JOKES_ROUTE = "jokes"
    const val JOKE_DETAIL_ROUTE = "joke"
    const val JOKE_DETAIL_ID_KEY = "jokeId"
}

@Composable
fun AppNavigation(startDestination: String = AppDestinations.JOKES_ROUTE, vm : JokeViewModel) {

    val navController = rememberNavController()
    val actions = remember(navController) { AppActions(navController, vm) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(
            AppDestinations.JOKES_ROUTE
        ) {
            ListScreen(vm = vm, selectedJoke = actions.selectedJoke)
        }

        composable(
            "${AppDestinations.JOKE_DETAIL_ROUTE}/{$JOKE_DETAIL_ID_KEY}",
            arguments = listOf(
                navArgument(JOKE_DETAIL_ID_KEY) {
                    type = NavType.IntType
                }
            )
        ) {
            JokeDetails(
                navigateUp = actions.navigateUp,
                joke = vm.state.selectedJoke!!
            )
        }
    }
}

private class AppActions(
    navController: NavHostController,
    vm : JokeViewModel
) {
    val selectedJoke: (Joke) -> Unit = { joke : Joke ->
        vm.selectJoke(joke)
        navController.navigate("${AppDestinations.JOKE_DETAIL_ROUTE}/${joke.id}")
    }
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}