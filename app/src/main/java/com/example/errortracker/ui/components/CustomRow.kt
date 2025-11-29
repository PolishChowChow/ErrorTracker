package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomRow(
    modifier: Modifier = Modifier,
    defaultWeight: Float = 1f,
    wrap: @Composable (child: @Composable () -> Unit, weight: Float) -> Unit,
    vararg children: Pair<@Composable () -> Unit, Float?>
) {
    Card() {
        Row(
            modifier = modifier
        ) {
            for ((child, weight) in children) {
                wrap(child, weight ?: defaultWeight)
            }
        }
    }
}
