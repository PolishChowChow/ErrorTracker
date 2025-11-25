package com.example.errortracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onNavigateToGraph: () -> Unit,
    onNavigateToList: () -> Unit
) {
    Column {
        Button(onClick = { onNavigateToGraph() }) {
            Text("Go to graph")
        }
        Button(onClick = { onNavigateToList() }) {
            Text("Go to List")
        }
    }
}