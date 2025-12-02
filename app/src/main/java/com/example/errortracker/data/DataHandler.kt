package com.example.errortracker.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import java.util.UUID

class DataHandler {
    private val records = mutableStateListOf<Record>()
    private val aggregatedErrorCodes = records
    fun addErrorCode(record: Record) {
        this.records.add(
            record
        )
    }

    fun removeErrorCode(id: UUID) {
        this.records.removeIf { it.id.equals(id) }
    }

    fun codes(): SnapshotStateList<Record> {
        return this.aggregatedErrorCodes
    }

}