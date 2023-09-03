package com.karnamic.wealthpix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.karnamic.wealthpix.ui.navigation.Navigation
import com.karnamic.wealthpix.ui.navigation.Screen
import com.karnamic.wealthpix.ui.theme.WealthPixTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WealthPixTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    Scaffold(bottomBar = {
                        BottomBar(navController)
                    }) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}


@Composable
fun BottomBar(navHostController: NavHostController) {

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        Screen.getBottomNavigationScreens().forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    navHostController.navigate(screen.route)
                },
                label = {
                    Text(text = screen.title)
                },
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        imageVector = if (selectedItemIndex == index) {
                            screen.selectedIcon!!
                        } else {
                            screen.unselectedIcon!!
                        },
                        contentDescription = screen.title
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    WealthPixTheme {
//        Navigation()
    }
}