package com.karnamic.wealthpix.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.capitalize
import java.util.*
import kotlin.collections.ArrayList

sealed class Screen(
    val route: String,
    val title: String = route.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
    val selectedIcon: ImageVector? = null,
    val unselectedIcon: ImageVector? = null
) {

    object HomeScreen : Screen(
        route = "home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home
    )

    object NewsScreen : Screen(
        route = "news",
        selectedIcon = Icons.Filled.Info,
        unselectedIcon = Icons.Outlined.Info
    )

    object WatchlistScreen : Screen(
        route = "watchlist",
        selectedIcon = Icons.Filled.Notifications,
        unselectedIcon = Icons.Outlined.Notifications
    )

    object SettingsScreen : Screen(
        route = "settings",
        selectedIcon = Icons.Filled.Settings,
        unselectedIcon = Icons.Outlined.Settings
    )

    object InstrumentScreen : Screen("instrument")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    companion object {
        fun getBottomNavigationScreens(): List<Screen> {
            return listOf(
                HomeScreen,
                NewsScreen,
                WatchlistScreen,
                SettingsScreen
            )
        }
    }
}


