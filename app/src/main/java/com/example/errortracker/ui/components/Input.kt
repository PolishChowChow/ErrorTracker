package com.example.errortracker.ui.components

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign


@Composable
fun Input(
    modifier: Modifier = Modifier,
    textValue: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable () -> Unit
) {
    TextField(
        value = textValue,
        textStyle = TextStyle(textAlign = TextAlign.Center),
        onValueChange = { it -> onValueChange(it) },
        modifier = modifier,
        placeholder = { placeholder }
    )
}