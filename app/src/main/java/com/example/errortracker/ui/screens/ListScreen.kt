package com.example.errortracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.errortracker.data.ErrorCode
import com.example.errortracker.ui.components.Form
import java.util.UUID

@Composable
fun ListScreen(
    addErrorRecord: (errorRecord: ErrorCode) -> Unit,
    removeErrorCode: (id: UUID) -> Unit,
    errorRecords: SnapshotStateList<ErrorCode>
) {
    Column(modifier = Modifier.padding(top = 50.dp).fillMaxWidth()) {
        Row() {
            Column() {
                errorRecords.forEach { record ->
                    Row (modifier = Modifier.fillMaxWidth().padding(20.dp, 2.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
                        Column() {
                            Text(text=record.operation, modifier = Modifier.size(80.dp, 50.dp).padding(2.dp).wrapContentSize(
                                Alignment.Center))
                        }
                        Column() {
                            Text(text=record.structure, modifier = Modifier.size(80.dp, 50.dp).padding(2.dp).wrapContentSize(
                                Alignment.Center))
                        }
                        Column() {
                            Text(text=record.errorValue, modifier = Modifier.size(80.dp, 50.dp).padding(2.dp).wrapContentSize(
                                Alignment.Center))
                        }
                        Column() {
                            Button(
                                onClick = { removeErrorCode(record.id)},
                            ) {
                                Text("-")
                            }
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