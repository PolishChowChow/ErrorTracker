package com.example.errortracker.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.sp
import com.example.errortracker.data.Record
import com.example.errortracker.ui.theme.AppTheme


@Composable
fun Form(
    onSubmit: (errorRecord: Record) -> Unit,
    onClose: () -> Unit
) {
    val tags = listOf<String>(
        "OP10.1",
        "OP10.2",
        "NEST 1",
        "NEST 2",
        "OP30.1",
        "OP30.2",
        "OP30.3",
        "OP30.4",
        "OP15.1",
        "OP15.2",
        "Op20",
        "Op75",
        "R01",
        "R02",
        "R03",
        "R04",
        "R05",
        "R06",
        "R07",
        "R08",
        "R09",
        "R10",
        "R11",
        "R17",
    )
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

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceContainerLowest)
            .padding(30.dp)
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text="Create new record", fontSize = 20.sp)
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
                placeholder = { PlaceholderComponent(textValue = "Wire stick is still being detected") },
                labelStr = "Error message",
            )
        }, {
            Input(
                textValue = formData.description,
                onValueChange = { formData = formData.copy(description = it) },
                placeholder = { PlaceholderComponent(textValue = "Problem description") },
                labelStr = "Problem description",
            )
        },{
            TagInputContainer(
                tags = tags,
                actualTags = formData.tags as MutableList<String>,
                onPress = {
                    formData = formData.copy()
                },
            )
        },
            {
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