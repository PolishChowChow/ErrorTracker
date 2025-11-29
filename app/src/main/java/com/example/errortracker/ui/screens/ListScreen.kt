package com.example.errortracker.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.errortracker.data.DataHandler
import com.example.errortracker.data.ErrorCode
import com.example.errortracker.ui.components.ListItem
import java.util.UUID

@Composable
fun ListScreen(
    removeErrorCode: (id: UUID) -> Unit, errorRecords: SnapshotStateList<ErrorCode>
) {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxHeight(.9f)
            .fillMaxWidth(1f)) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                items(items = errorRecords, key = { it.id }) { record ->
                    val enterState = remember {
                        MutableTransitionState(false).apply { targetState = true }
                    }
                    AnimatedVisibility(
                        visibleState = enterState,
                        enter = fadeIn(animationSpec = tween(220)) + slideInVertically(
                            initialOffsetY = { it / 4 }),
                        exit = fadeOut()
                    ) {
                        Row(
                            modifier = Modifier.padding(bottom = 20.dp)
                        ) {
                            ListItem(record, removeErrorCode = removeErrorCode)
                        }
                    }
                }
            }
        }
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
        errorRecords = records.errorCodes, removeErrorCode = records::removeErrorCode
    )
}