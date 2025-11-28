package com.example.errortracker.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun PlaceholderComponent(
    modifier: Modifier = Modifier,
    textValue: String,
) {
    Text(
        text = textValue,
        modifier = modifier,
        color = Color(128,128,128),
        fontSize = 14.sp
    )
}