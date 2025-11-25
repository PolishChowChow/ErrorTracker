package com.example.errortracker.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object List : Screen("list")
    object Graph : Screen("graph")
}
