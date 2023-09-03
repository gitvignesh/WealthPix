package com.karnamic.wealthpix.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.karnamic.wealthpix.ui.*
import com.karnamic.wealthpix.ui.navigation.Screen.*

@Composable
fun Navigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = HomeScreen.route) {
        composable(route = HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = NewsScreen.route) {
            NewsScreen()
        }

        composable(route = WatchlistScreen.route) {
            WatchlistScreen()
        }

        composable(route = SettingsScreen.route) {
            SettingsScreen()
        }

        composable(
            route = InstrumentScreen.route + "/{instrument}",
            arguments = listOf(
                navArgument("instrument") {
                    type = NavType.StringType
                    defaultValue = "Instrument"
                    nullable = false
                }
            )
        ) { entry ->
            InstrumentScreen(
                instrument = entry.arguments?.getString("instrument")
            )
        }
    }
}