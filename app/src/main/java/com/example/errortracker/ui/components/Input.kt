package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Input(
    modifier: Modifier = Modifier,
    textValue: String,
    onValueChange: (String) -> Unit,
    placeholder: @Composable () -> Unit,
    labelStr: String = "",
    prefixStr: String = ""
) {
    OutlinedTextField(
        value = textValue,
        textStyle = TextStyle(textAlign = TextAlign.Left),
        onValueChange = { onValueChange(it) },
        modifier = modifier,
        placeholder = { placeholder() },
        label = { Text(labelStr) },
        prefix = { Text(prefixStr) }
    )
}

@Preview(showBackground = true)
@Composable
fun TestInput(){
    Box(
        modifier = Modifier.padding(30.dp)
    ){
        Input(
            textValue = "",
            onValueChange = {  },
            modifier = Modifier,
            placeholder = { Text("Placeholder") },
            labelStr = "Operation",
            prefixStr = "Op",
        )
    }
}