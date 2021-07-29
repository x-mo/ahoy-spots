package com.xmo.core.network.responses

data class ConnectionType(
    val FormalName: Any,
    val ID: Int,
    val IsDiscontinued: Boolean,
    val IsObsolete: Boolean,
    val Title: String
)