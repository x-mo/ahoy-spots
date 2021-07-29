package com.xmo.core.network.responses

data class StatusType(
    val ID: Int,
    val IsOperational: Boolean,
    val IsUserSelectable: Boolean,
    val Title: String
)