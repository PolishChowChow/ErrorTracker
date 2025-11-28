package com.example.errortracker.data

import java.util.UUID

data class ErrorCode(
    var operation: String,
    var structure: String,
    var errorValue: String,
) {
    val id = UUID.randomUUID()
}