package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.errortracker.data.Record
import com.example.errortracker.ui.theme.AppTheme


@Composable
fun Form(
    onSubmit: (errorRecord: Record) -> Unit,
    onClose: () -> Unit
) {
    var formData by remember { mutableStateOf(Record("","", emptyList<String>())) }
    fun clearFormData() {
        formData = formData.copy(
            content = "",
            description = "",
            tags = emptyList<String>(),
        )
    }


    CustomColumn(modifier = Modifier, wrap = { child ->
        Box(
            modifier = Modifier.padding(5.dp).fillMaxWidth(1f)) {
            child()
        }
    }, {
        Input(
            textValue = formData.content,
            onValueChange = { formData = formData.copy(content = it) },
            placeholder = { PlaceholderComponent(textValue = "30.3") },
            labelStr = "Operation",
            prefixStr = "OP"
        )
    }, {
        Input(
            textValue = formData.description,
            onValueChange = { formData = formData.copy(description = it) },
            placeholder = { PlaceholderComponent(textValue = "Z10.2") },
            labelStr = "Structure",
        )
    }, {
        Input(
            textValue = formData.potentialSolution,
            onValueChange = { formData = formData.copy(potentialSolution = it) },
            placeholder = { PlaceholderComponent(textValue = "Wire stick is still being detected") },
            labelStr = "Error value",
        )
    }, {
        Button(
            onClick = {
                onSubmit(formData)
                clearFormData()
                onClose()
            }) {
            Text("Add new record")
        }
    })
}


@Preview(showBackground = true)
@Composable
fun TestForm() {
    AppTheme {
        Form(
            onSubmit = { },
            onClose = { }
        )
    }
}