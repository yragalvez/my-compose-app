package com.example.first

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun HomeDetailScreen(navigator: DestinationsNavigator) {
    Column {
        Text(text = "This is the DETAILS screen")

        Button(onClick = { navigator.navigateUp() }) {
            Text(text = "Navigate BACK to Home Screen")
        }
    }
}