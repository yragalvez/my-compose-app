package com.example.first

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun FirstScreen() {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            Text("First screen")
        }
    }
}