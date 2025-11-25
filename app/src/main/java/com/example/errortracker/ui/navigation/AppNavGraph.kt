package com.example.errortracker.ui.navigation
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import com.example.errortracker.ui.screens.HomeScreen
import com.example.errortracker.ui.screens.ListScreen
import com.example.errortracker.ui.screens.GraphScreen

@Composable
fun AppNavGraph(navController: NavHostController, startDestination: Screen = Screen.Home){
    NavHost(
        navController = navController,
        startDestination= Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToGraph = {
                    navController.navigate(Screen.Graph.route)
                },
                onNavigateToList = {
                    navController.navigate(Screen.List.route)
                }
            )
        }
        composable(Screen.Graph.route) {
            GraphScreen()
        }
        composable(Screen.List.route) {
            ListScreen()
        }
    }
}