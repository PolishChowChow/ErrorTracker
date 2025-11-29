package com.example.errortracker.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import java.util.UUID

class DataHandler {
    val errorCodes = mutableStateListOf<ErrorCode>()
    val aggredatedErrorCodes = errorCodes
    fun addErrorCode(errorCode: ErrorCode) {
        this.errorCodes.add(
            ErrorCode(
                structure = errorCode.structure.lowercase(),
                operation = errorCode.operation.lowercase(),
                errorValue = errorCode.errorValue.lowercase(),
            )
        )
    }

    fun removeErrorCode(id: UUID) {
        this.errorCodes.removeIf { it.id.equals(id) }
    }

    fun codes(): SnapshotStateList<ErrorCode> {
        return this.aggredatedErrorCodes
    }

}