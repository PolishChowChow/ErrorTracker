package com.example.errortracker.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.errortracker.data.ErrorCode
import com.example.errortracker.ui.components.CustomRow
import com.example.errortracker.ui.components.Form
import com.example.errortracker.ui.components.TextComponent
import java.util.UUID

@Composable
fun ListScreen(
    addErrorRecord: (errorRecord: ErrorCode) -> Unit,
    removeErrorCode: (id: UUID) -> Unit,
    errorRecords: SnapshotStateList<ErrorCode>
) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row {
            Column {
                CustomRow(
                    modifier = Modifier, 1f, wrap = { child, weight ->
                    Box(
                        modifier = Modifier
                            .weight(weight)
                            .fillMaxHeight()
                            .padding(5.dp)
                    ) {
                        child()
                    }
                }, children = arrayOf((@Composable {
                    TextComponent(text = "operation")
                } to 1f), (@Composable {
                    TextComponent(text = "structure")
                } to 1f), (@Composable {
                    TextComponent(text = "error")
                } to 1f), (@Composable {
                    TextComponent(text = "")
                } to .6f)))
                errorRecords.forEach { record ->
                    CustomRow(
                        modifier = Modifier, wrap = { child, weight ->
                        Box(
                            modifier = Modifier
                                .weight(weight)
                                .fillMaxHeight()
                                .padding(5.dp)
                        ) {
                            child()
                        }
                    }, children = arrayOf((@Composable {
                        TextComponent(text = record.operation)
                    } to 1f), (@Composable {
                        TextComponent(text = record.structure)
                    } to 1f), (@Composable {
                        TextComponent(text = record.errorValue)
                    } to 1f), (@Composable {
                        Button(
                            onClick = { removeErrorCode(record.id) },
                        ) {
                            Text("-")
                        }
                    } to .6f)))
                }
            }
        }
        Form(
            addErrorRecord = addErrorRecord
        )
    }
}

