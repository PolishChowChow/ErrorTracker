package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
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
    Row() {
        CustomRow(
            modifier = Modifier,
            wrap = { child ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(5.dp)
                ){
                    child()
                }
            },
            {
                Input(
                    textValue = formData.operation,
                    onValueChange = { it ->  formData = formData.copy(operation = it) },
                    placeholder = { Text("Op30.3") }
                )
            },
            {
                Input(
                    textValue = formData.structure,
                    onValueChange = { it ->  formData = formData.copy(structure = it) },
                    placeholder = { Text("R10") }

                )
            },
            {
                Input(
                    textValue = formData.errorValue,
                    onValueChange = { it ->  formData = formData.copy(errorValue = it) },
                    placeholder = { Text("Wirestick") }
                )
            },
            {
                Button(
                    onClick = {
                        addErrorRecord(formData);
                        clearFormData(); },
                ) {
                    Text("+")
                }
            }

        )
    }
}