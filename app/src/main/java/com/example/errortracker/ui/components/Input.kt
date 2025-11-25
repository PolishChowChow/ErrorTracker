package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Input(
    textValue: String,
    onValueChange: (String) -> Unit,
    placeholder: String? = null,
) {
    val placeholderConditionally:String = if(checkNotNull(placeholder) != "" && placeholder != "") placeholder else ""
    TextField(
        value = textValue,
        textStyle = TextStyle(fontSize = 10.sp, textAlign = TextAlign.Center),
        onValueChange = { it -> onValueChange(it) },
        modifier = Modifier.size(80.dp, 50.dp),
    )
}