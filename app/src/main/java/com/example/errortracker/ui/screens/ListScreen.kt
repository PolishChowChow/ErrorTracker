package com.example.errortracker.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.errortracker.data.ErrorCode
import com.example.errortracker.ui.components.Form

@Composable
fun ListScreen(
    addErrorRecord: (errorRecord: ErrorCode) -> Unit,
    errorRecords: SnapshotStateList<ErrorCode>
) {
    Column(modifier = Modifier.padding(top = 50.dp)) {
        Row() {
            Column() {
                errorRecords.forEach { record ->
                    Row(modifier = Modifier.padding(bottom = 20.dp)) {
                        Column() {
                            Text(text=record.operation)
                        }
                        Column() {
                            Text(text=record.structure)
                        }
                        Column() {
                            Text(text=record.errorValue)
                        }
                        Column() {
                            Text(text=record.additionalInfo)
                        }
                    }
                }
            }
        }
        Row() {
            Form(
                addErrorRecord = addErrorRecord
            )
        }
    }

}