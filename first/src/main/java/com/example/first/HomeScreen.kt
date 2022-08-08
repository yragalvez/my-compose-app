package com.example.first

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.first.destinations.HomeDetailScreenDestination
import com.example.first.ui.theme.MyComposeAppTheme
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    MyComposeAppTheme {
        Greeting(navigator)
    }
}

@Composable
fun Greeting(navigator: DestinationsNavigator) {

    Column {
        Text(text = "This is the home screen")
        Button(onClick = { navigator.navigate(HomeDetailScreenDestination) }) {
            Text(text = "Navigate to Home Details Screen")
        }
    }

}