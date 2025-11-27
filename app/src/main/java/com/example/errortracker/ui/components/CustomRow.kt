package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomRow(
    modifier: Modifier = Modifier,
    wrap: @Composable (child: @Composable () -> Unit) -> Unit,
    vararg children: @Composable () -> Unit
) {
    Row(modifier = modifier) {
        for (child in children) {
            wrap(child)
        }
    }
}
