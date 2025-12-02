package com.example.errortracker.ui.components


import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import com.example.errortracker.data.Record


@Composable
fun DialogForm(
    onDismissRequest: () -> Unit, onSubmit: (Record) -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        Form(
            onSubmit = onSubmit,
            onClose = onDismissRequest
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TestDialog() {
    DialogForm(onDismissRequest = {}, onSubmit = {})
}