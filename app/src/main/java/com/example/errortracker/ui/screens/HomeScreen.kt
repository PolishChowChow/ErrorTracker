package com.example.errortracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

data class ErrorCode(
    val id: Int,
    val operation: String,
    val structure: String,
    val error_value: String,
    val additional_info: String? = null
)
@Composable
fun HomeScreen(
    onNavigateToGraph: () -> Unit,
    onNavigateToList: () -> Unit
) {
    val errorCodes = remember { mutableStateListOf<ErrorCode>() }

    Column {
        Button(onClick = { onNavigateToGraph() }) {
            Text("Go to graph")
        }
        Button(onClick = { onNavigateToList() }) {
            Text("Go to List")
        }
    }
}