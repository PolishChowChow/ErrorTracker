package com.example.errortracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextComponent(
    text: String,
    modifier: Modifier = Modifier
){
    Text(
        text=text,
        modifier = modifier
            .size(80.dp, 50.dp)
            .padding(2.dp)
            .wrapContentSize(
                Alignment.Center
            )
    )
}

