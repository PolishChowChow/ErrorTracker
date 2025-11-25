package com.example.errortracker.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.TextFieldValue


@Composable
fun Form(){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var text1 by remember { mutableStateOf(TextFieldValue("")) }
    fun setter(value: TextFieldValue){
        text = value
    }
    fun setter1(value: TextFieldValue){
        text1 = value
    }
    Row () {
        Column() {
            Input(
                textValue = text,
                onValueChange = { it -> setter(it ) },
                placeholder = "siema"
            )
        }
        Column() {
            Input(
                textValue = text1,
                onValueChange = { it -> setter1(it ) },
                placeholder = "siema"
            )
        }

    }
}