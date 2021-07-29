package com.xmo.core.network.responses

data class Connection(
    val Amps: Int,
    val Comments: Any,
    val ConnectionType: ConnectionType,
    val ConnectionTypeID: Int,
    val CurrentType: CurrentType,
    val CurrentTypeID: Int,
    val ID: Int,
    val Level: Level,
    val LevelID: Int,
    val PowerKW: Double,
    val Quantity: Int,
    val Reference: Any,
    val StatusType: StatusType,
    val StatusTypeID: Int,
    val Voltage: Int
)