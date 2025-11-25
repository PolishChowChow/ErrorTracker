package com.example.errortracker.data

data class ErrorCode(
    var operation: String,
    var structure: String,
    var errorValue: String,
    var additionalInfo: String
)