package com.example.errortracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(){
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text="Tracker",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top=40.dp).fillMaxWidth(),
            fontSize = 30.sp
        )
    }
}