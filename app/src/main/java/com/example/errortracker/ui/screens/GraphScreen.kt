package com.example.errortracker.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.errortracker.data.Record
import com.example.errortracker.ui.components.Form

@Composable
fun GraphScreen(
    addErrorRecord: (errorRecord: Record) -> Unit,
) {
    Form(
        onSubmit = addErrorRecord,
        onClose = { }
    )
}