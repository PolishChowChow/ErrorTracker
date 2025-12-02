package com.example.errortracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
    val tags = listOf<String>("Op30.3","Op30.1","Op30.2","Op30.4","R06","R05")
    var formData by remember {
        mutableStateOf(
            value=Record(
                content="",
                description = "",
                tags = mutableStateListOf<String>()
            )) }

    fun clearFormData() {
        formData = formData.copy(
            content = "",
            description = "",
            tags = emptyList(),
        )
    }

    CustomColumn(modifier = Modifier.background(MaterialTheme.colorScheme.surfaceContainerLowest), wrap = { child ->
        Box(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(1f)) {
            child()
        }
    }, {
        Input(
            textValue = formData.content,
            onValueChange = { formData = formData.copy(content = it) },
            placeholder = { PlaceholderComponent(textValue = "30.3") },
            labelStr = "Error message",
        )
    }, {
        Input(
            textValue = formData.description,
            onValueChange = { formData = formData.copy(description = it) },
            placeholder = { PlaceholderComponent(textValue = "Z10.2") },
            labelStr = "Description",
        )
    },{
        TagInputContainer(
            tags = tags,
            actualTags = formData.tags as MutableList<String>,
            onPress = {
                formData = formData.copy()
            },
        )
    },{
        Text(formData.tags.toString())
    },{
        Input(
            textValue = formData.potentialSolution,
            onValueChange = { formData = formData.copy(potentialSolution = it) },
            placeholder = { PlaceholderComponent(textValue = "Wire stick is still being detected") },
            labelStr = "Potential solution",
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