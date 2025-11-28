package com.example.errortracker.data

enum class ErrorCodesSortKey(val selector: (ErrorCode) -> Comparable<Any?>) {
    OPERATION({ it.operation as Comparable<Any?> }), STRUCTURE({ it.structure as Comparable<Any?> }), ERROR_CODE(
        { it.errorValue as Comparable<Any?> })
}

object AggregateData {
    fun <R : Comparable<R>> sortByKey(
        codes: List<ErrorCode>, selector: (ErrorCode) -> R, ascending: Boolean = true
    ): List<ErrorCode> {
        return if (ascending) codes.sortedBy(selector) else codes.sortedByDescending(selector)
    }

    fun <K> groupBy(
        codes: List<ErrorCode>, classifier: (ErrorCode) -> K
    ): Map<K, List<ErrorCode>> = codes.groupBy(classifier)
}
