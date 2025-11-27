package com.example.errortracker.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import java.util.UUID

class DataHandler {
    val errorCodes =  mutableStateListOf<ErrorCode>();
    val aggredatedErrorCodes = errorCodes
    fun addErrorCode(errorCode: ErrorCode){
        this.errorCodes.add(errorCode)
    }
    fun removeErrorCode(id: UUID){
        this.errorCodes.removeIf { it -> it.id.equals(id) }
    }
    fun codes():SnapshotStateList<ErrorCode>{
        return this.aggredatedErrorCodes
    }

}