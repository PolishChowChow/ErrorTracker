package com.example.errortracker.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.errortracker.data.DataHandler
import com.example.errortracker.data.ErrorCode
import com.example.errortracker.ui.components.Form
import com.example.errortracker.ui.components.ListItem
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
                errorRecords.forEach { record ->
                    Box(
                        modifier = Modifier.padding(bottom = 20.dp)
                    ){
                        ListItem(record, removeErrorCode = removeErrorCode)
                    }
                }
            }
        }
        Form(
            addErrorRecord = addErrorRecord
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TestListScreen() {
    val records = DataHandler()

    records.addErrorCode(ErrorCode("OP30.3", "R15", "Kolizja robota"))
    records.addErrorCode(ErrorCode("OP30.3", "R15", "Kolizja robota"))
    records.addErrorCode(ErrorCode("OP30.3", "R15", "Kolizja robota"))
    records.addErrorCode(ErrorCode("OP30.3", "R15", "Kolizja robota"))

    ListScreen(
        errorRecords = records.errorCodes,
        addErrorRecord = records::addErrorCode,
        removeErrorCode = records::removeErrorCode
    )
}