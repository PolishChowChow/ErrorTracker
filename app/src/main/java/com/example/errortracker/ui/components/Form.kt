package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Column (
        modifier = Modifier.fillMaxWidth(1f).fillMaxHeight(.83f).padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Box(
            modifier = Modifier.padding(30.dp)
        ) {
            Text("Create new record")
        }

        CustomRow(
            modifier = Modifier,
            wrap = { child ->
                Box(
                    modifier = Modifier
                        .padding(5.dp)
                ) {
                    child()
                }
            },
            {
                Input(
                    textValue = formData.operation,
                    onValueChange = { formData = formData.copy(operation = it) },
                    placeholder = { PlaceholderComponent(textValue = "30.3") },
                    labelStr = "Operation",
                    prefixStr = "OP"
                )
            },
            {
                Input(
                    textValue = formData.structure,
                    onValueChange = { formData = formData.copy(structure = it) },
                    placeholder = { PlaceholderComponent(textValue = "Z10.2") },
                    labelStr = "Structure",
                )
            },
            {
                Input(
                    textValue = formData.errorValue,
                    onValueChange = { formData = formData.copy(errorValue = it) },
                    placeholder = { PlaceholderComponent(textValue = "Wire stick is still being detected")},
                    labelStr = "Error value",
                )
            },
            {
                Button(
                    onClick = {
                        addErrorRecord(formData)
                        clearFormData()
                    }
                ) {
                    Text("Add new record")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TestForm() {
    Form { }
}