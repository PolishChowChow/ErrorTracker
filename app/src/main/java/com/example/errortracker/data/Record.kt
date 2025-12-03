package com.example.errortracker.data

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.UUID

data class Record(
    var content: String,
    var description: String = "",
    var tags: List<String>,
    var date: LocalDateTime = LocalDateTime.of(
        LocalDate.now(),
        LocalTime.now()
    ),
) {
    val id = UUID.randomUUID()
}