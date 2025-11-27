package com.example.errortracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable


fun ExampleTable() {
    var string = "SIEMA"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),  // adjust height as needed
        horizontalArrangement = Arrangement.spacedBy(8.dp) // space between boxes
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Red)
        )
        {
            Input(
                modifier = Modifier,
                textValue = string,
                onValueChange = { string = it},
                placeholder = { Text("Wirestick") }

            )
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Green)
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(Color.Blue)
        )
    }
}
