package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomColumn(
    modifier: Modifier = Modifier,
    wrap: @Composable (child: @Composable () -> Unit) -> Unit,
    vararg children: @Composable () -> Unit
) {
    Card() {
        Column(
            modifier = modifier
        ) {
            for (child in children) {
                wrap(child)
            }
        }
    }
}
