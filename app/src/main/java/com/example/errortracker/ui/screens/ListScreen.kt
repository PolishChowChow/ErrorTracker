package com.example.errortracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.errortracker.ui.components.Form

@Composable
fun ListScreen() {
    Column() {
        Row() {
            Text("List screen")
        }
        Row() {
            Form()
        }
    }

}