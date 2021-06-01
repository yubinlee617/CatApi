package com.example.dataproject.models

data class MyCat(
    val type: String,
    val deleted: Boolean,
    val text: String,
    val source: String,
    val status: StatusInfo,
    val used: Boolean

) {
    data class StatusInfo(
        val verified: Boolean,
        val setCount: Int
    )
}