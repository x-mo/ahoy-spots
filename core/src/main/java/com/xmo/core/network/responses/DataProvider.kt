package com.xmo.core.network.responses

data class DataProvider(
    val Comments: Any,
    val DataProviderStatusType: DataProviderStatusType,
    val DateLastImported: Any,
    val ID: Int,
    val IsApprovedImport: Boolean,
    val IsOpenDataLicensed: Boolean,
    val IsRestrictedEdit: Boolean,
    val License: String,
    val Title: String,
    val WebsiteURL: String
)