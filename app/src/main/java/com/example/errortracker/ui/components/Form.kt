package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.errortracker.data.ErrorCode


@Composable
fun Form(
    addErrorRecord: (errorRecord: ErrorCode) -> Unit,
){
    var formData by remember { mutableStateOf(ErrorCode("","","","")) }
    fun clearFormData(){
        formData = formData.copy(
            operation = "",
            errorValue = "",
            structure = "",
            additionalInfo = ""
        )
    }
    Row () {
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
            Input(
                textValue = formData.additionalInfo,
                onValueChange = { it ->  formData = formData.copy(additionalInfo = it) },
                placeholder = "BAD"
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