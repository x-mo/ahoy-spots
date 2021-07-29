package com.xmo.core.network.responses

data class OperatorInfo(
    val AddressInfo: Any,
    val BookingURL: Any,
    val Comments: Any,
    val ContactEmail: Any,
    val FaultReportEmail: Any,
    val ID: Int,
    val IsPrivateIndividual: Any,
    val IsRestrictedEdit: Any,
    val PhonePrimaryContact: Any,
    val PhoneSecondaryContact: Any,
    val Title: String,
    val WebsiteURL: String
)