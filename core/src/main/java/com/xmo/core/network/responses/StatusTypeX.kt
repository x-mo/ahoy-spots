package com.xmo.core.network.responses

data class StatusTypeX(
    val ID: Int,
    val IsOperational: Boolean,
    val IsUserSelectable: Boolean,
    val Title: String
)