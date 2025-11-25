package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun Input(
    textValue: String,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
) {
    val placeholderConditionally:String = if(checkNotNull(placeholder) != "" && placeholder != "") placeholder else ""
    TextField(
        value = textValue,
        onValueChange = { it -> onValueChange(it) },
        label = { Text(text=placeholderConditionally) },
        modifier = Modifier.size(70.dp, 50.dp).padding(2.dp)
    )
}