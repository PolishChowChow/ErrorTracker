package com.example.errortracker.ui.navigation


import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun NavBar(
    actualRoute: String?, onListPress: () -> Unit, onGraphPress: () -> Unit
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxSize()
    ) {
        NavigationBarItem(
            selected = actualRoute == "list",
            onClick = onListPress,
            label = { Text("list") },
            icon = {
            Icon(
                imageVector = Icons.Filled.Home, contentDescription = "List",
                modifier = Modifier.size(30.dp)
            )
        })
        NavigationBarItem(
            selected = actualRoute == "graph",
            onClick = onGraphPress,
            label = { Text("graph") },
            icon = {
            Icon(
                imageVector = Icons.Filled.Info, contentDescription = "Graph",
                modifier = Modifier.size(30.dp)
            )
        })

    }
}