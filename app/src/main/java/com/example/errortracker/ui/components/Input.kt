package com.example.errortracker.ui.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue


@Composable
fun Input(
    textValue: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String? = null,
//    function: () -> Unit
) {
    val placeholderConditionally:String = if(checkNotNull(placeholder) != "" && placeholder != "") placeholder else ""
    TextField(
        value = textValue,
        onValueChange = { it -> onValueChange(it) },
        label = { Text(text=placeholderConditionally) }
    )
}
