package com.example.errortracker.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.errortracker.data.DataHandler
import com.example.errortracker.ui.components.Header
import com.example.errortracker.ui.screens.GraphScreen
import com.example.errortracker.ui.screens.ListScreen

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier) {
    val errorCodes = remember { DataHandler() }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Column(modifier = Modifier.fillMaxHeight()) {
        Row {
            Header()
        }
        Row {
            NavHost(
                navController = navController,
                startDestination = Screen.List.route,
                contentAlignment = Alignment.Center
            ) {
                composable(Screen.Graph.route) {
                    GraphScreen(
                        addErrorRecord = errorCodes::addErrorCode
                    )
                }
                composable(Screen.List.route) {
                    ListScreen(
                        removeErrorCode = errorCodes::removeErrorCode,
                        errorRecords = errorCodes.codes()
                    )
                }
            }
        }
        Row {
            NavBar(
                actualRoute = currentRoute,
                onGraphPress = { navController.navigate(Screen.Graph.route) },
                onListPress = { navController.navigate(Screen.List.route) })
        }

    }
}