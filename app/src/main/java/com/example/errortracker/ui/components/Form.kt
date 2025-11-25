package com.example.errortracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.errortracker.data.ErrorCode


@Composable
fun Form(
    addErrorRecord: (errorRecord: ErrorCode) -> Unit,
){
    var formData by remember { mutableStateOf(ErrorCode("","","")) }
    fun clearFormData(){
        formData = formData.copy(
            operation = "",
            errorValue = "",
            structure = "",
        )
    }
    Row (modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
        Column() {
            Input(
                textValue = formData.operation,
                onValueChange = { it ->  formData = formData.copy(operation = it) },
                placeholder = "OP10"
            )
        }
        Column() {
            Input(
                textValue = formData.structure,
                onValueChange = { it ->  formData = formData.copy(structure = it) },
                placeholder = "R5",
            )
        }
        Column() {
            Input(
                textValue = formData.errorValue,
                onValueChange = { it ->  formData = formData.copy(errorValue = it) },
                placeholder = "WS"
            )
        }
        Column() {
            Button(
                onClick = {
                    addErrorRecord(formData);
                    clearFormData(); },
            ) {
                Text("+")
            }
        }
    }
}