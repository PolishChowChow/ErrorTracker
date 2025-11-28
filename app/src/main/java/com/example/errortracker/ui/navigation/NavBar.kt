package com.example.errortracker.ui.navigation


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun NavBar(
    actualRoute: String?, onListPress: () -> Unit, onGraphPress: () -> Unit
) {
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        NavigationBarItem(selected = actualRoute == "list", onClick = onListPress, icon = {
            Icon(
                imageVector = Icons.Filled.Home, contentDescription = "List"
            )
        }, label = { Text("Graph") })
        NavigationBarItem(selected = actualRoute == "graph", onClick = onGraphPress, icon = {
            Icon(
                imageVector = Icons.Filled.Info, contentDescription = "Graph"
            )
        }, label = { Text("Graph") })

    }
}