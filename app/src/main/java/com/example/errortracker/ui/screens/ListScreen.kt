package com.example.errortracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.example.errortracker.ui.components.CustomRow
import com.example.errortracker.ui.components.Form
import java.util.UUID

@Composable
fun ListScreen(
    addErrorRecord: (errorRecord: ErrorCode) -> Unit,
    removeErrorCode: (id: UUID) -> Unit,
    errorRecords: SnapshotStateList<ErrorCode>
) {
    Column(modifier =
        Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row() {
            Column() {
                CustomRow(
                    modifier = Modifier,
                    1f,
                    wrap = { child, weight ->
                        Box(
                            modifier = Modifier
                                .weight(weight)
                                .fillMaxHeight()
                        ){
                            child()
                        }
                    },
                    children = arrayOf(
                        (@Composable {
                            Text(text="operation", modifier = Modifier.size(80.dp, 50.dp).padding(2.dp).wrapContentSize(
                                Alignment.Center))
                        } to 1f),
                            (@Composable {
                            Text(text="structure", modifier = Modifier.size(80.dp, 50.dp).padding(2.dp).wrapContentSize(
                                Alignment.Center))
                        } to 1f),
                        (@Composable {
                            Text(text="error", modifier = Modifier.size(80.dp, 50.dp).padding(2.dp).wrapContentSize(
                                Alignment.Center))
                        } to 1f),
                        (@Composable {
                            Text(text="", modifier = Modifier.size(80.dp, 50.dp).padding(2.dp).wrapContentSize(
                                Alignment.Center))
                        } to .6f)
                    )
                )
                errorRecords.forEach { record ->
                    CustomRow (
                        modifier = Modifier,
                        wrap = { child, weight ->
                            Box(
                                modifier = Modifier
                                    .weight(weight)
                                    .fillMaxHeight()
//                                    .padding(5.dp)
                            ){
                                child()
                            }
                        },
                        children = arrayOf(
                            (@Composable {
                                Text(text=record.operation, modifier = Modifier.size(80.dp, 50.dp).padding(2.dp).wrapContentSize(
                                    Alignment.Center))
                            } to 1f),
                            (@Composable {
                                Text(text=record.structure, modifier = Modifier.size(80.dp, 50.dp).padding(2.dp).wrapContentSize(
                                    Alignment.Center))
                            } to 1f),
                            (@Composable {
                                Text(text=record.errorValue, modifier = Modifier.size(80.dp, 50.dp).padding(2.dp).wrapContentSize(
                                    Alignment.Center))
                            } to 1f),
                            (@Composable {
                                Button(
                                    onClick = { removeErrorCode(record.id)},
                                ) {
                                    Text("-")
                                }
                            } to .6f)
                        ))
                    }
                }
            }
        Form(
            addErrorRecord = addErrorRecord
        )
        }
    }

