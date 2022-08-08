package com.example.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LooksOne
import androidx.compose.material.icons.filled.LooksTwo
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.first.FirstNavGraph
import com.example.first.MainNavigation
import com.example.first.destinations.FirstScreenDestination
import com.example.first.destinations.HomeScreenDestination
import com.example.mycomposeapp.navigation.RootNavGraph
import com.example.second.destinations.SecondScreenDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigateTo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            val selected = remember { mutableStateOf(MainNavigation.NAVIGATION_MAIN) }

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                bottomBar = {
                    BottomAppBar {
                        BottomNavigation {
                            BottomNavigationItem(
                                selected = selected.value == MainNavigation.NAVIGATION_MAIN,
                                onClick = {
                                    selected.value = MainNavigation.NAVIGATION_MAIN
//                                    navigator.navigate(HomeScreenDestination)
                                    navController.navigateTo(HomeScreenDestination)
                                },
                                icon = {
                                    Icon(imageVector = Icons.Filled.Home, contentDescription = "")
                                },
                                label = { Text(text = "Home") })

                            BottomNavigationItem(
                                selected = selected.value == MainNavigation.NAVIGATION_FIRST,
                                onClick = {
                                    selected.value = MainNavigation.NAVIGATION_FIRST
                                    navController.navigateTo(FirstScreenDestination)
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Filled.LooksOne,
                                        contentDescription = ""
                                    )
                                },
                                label = { Text(text = "First") })

                            BottomNavigationItem(
                                selected = selected.value == MainNavigation.NAVIGATION_SECOND,
                                onClick = {
                                    selected.value = MainNavigation.NAVIGATION_SECOND
                                    navController.navigateTo(SecondScreenDestination("Yra Carmela Galvez"))
                                },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Filled.LooksTwo,
                                        contentDescription = ""
                                    )
                                },
                                label = { Text(text = "Second") })
                        }
                    }
                }
            ) {
                DestinationsNavHost(
                    navController = navController,
                    modifier = Modifier.padding(it),
                    navGraph = RootNavGraph,
                    startRoute = FirstNavGraph,
                    dependenciesContainerBuilder = {
//                        dependency(scaffoldState)
//                        dependency(CoreFeatureNavigator(destination, navController))
                    }
                )
            }
        }
    }
}

