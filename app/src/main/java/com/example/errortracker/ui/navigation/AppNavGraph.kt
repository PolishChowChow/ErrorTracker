package com.example.errortracker.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.errortracker.data.ErrorCode
import com.example.errortracker.ui.screens.ListScreen
import com.example.errortracker.ui.screens.GraphScreen
import org.w3c.dom.Text
import java.util.UUID

@Composable
fun AppNavGraph(navController: NavHostController, modifier: Modifier){
    val errorCodes = remember { mutableStateListOf<ErrorCode>() }
    fun pushErrorCode(errorCode: ErrorCode){
        errorCodes.add(errorCode)
    }
    fun removeErrorCode(id: UUID){
        errorCodes.removeIf { it -> it.id.equals(id) }
    }
    NavHost(
        navController = navController,
        startDestination = Screen.List.route
    ) {
        composable(Screen.Graph.route) {
            GraphScreen()
        }
        composable(Screen.List.route) {
            ListScreen(
                addErrorRecord = ::pushErrorCode,
                removeErrorCode = ::removeErrorCode,
                errorRecords = errorCodes

            )
        }
    }
    Row() {
        Column() {
            Button(onClick = { navController.navigate(Screen.List.route) } ){
                Text("List")
            }
        }
        Column() {
            Button(onClick = { navController.navigate(Screen.Graph.route) } ){
                Text("Graph")
            }
        }
    }
}