package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.errortracker.data.ErrorCode


@Composable
fun Form(
    addErrorRecord: (errorRecord: ErrorCode) -> Unit,
) {
    var formData by remember { mutableStateOf(ErrorCode("", "", "")) }
    fun clearFormData() {
        formData = formData.copy(
            operation = "",
            errorValue = "",
            structure = "",
        )
    }
    Row {
        CustomRow(
            modifier = Modifier,
            wrap = { child, weight ->
                Box(
                    modifier = Modifier
                        .weight(weight)
                        .fillMaxHeight()
                        .padding(5.dp)
                ) {
                    child()
                }
            },
            children = arrayOf(
                (@Composable {
                    Input(
                        textValue = formData.operation,
                        onValueChange = { formData = formData.copy(operation = it) },
                        placeholder = { PlaceholderComponent(textValue = "Op30.3") })
                } to 1f),
                (@Composable {
                    Input(
                        textValue = formData.structure,
                        onValueChange = { formData = formData.copy(structure = it) },
                        placeholder = { PlaceholderComponent(textValue = "R10") })
                } to 1f),
                (@Composable {
                    Input(
                        textValue = formData.errorValue,
                        onValueChange = { formData = formData.copy(errorValue = it) },
                        placeholder = { PlaceholderComponent(textValue = "R10") })
                } to 1f),
                (@Composable {
                    Button(
                        onClick = { addErrorRecord(formData) }) {
                        Text("+")
                    }
                } to .6f),
            ))
    }
}