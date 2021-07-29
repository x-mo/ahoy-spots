package com.xmo.core.network.responses

data class AddressInfo(
    val AccessComments: Any,
    val AddressLine1: String,
    val AddressLine2: Any,
    val ContactEmail: Any,
    val ContactTelephone1: String,
    val ContactTelephone2: Any,
    val Country: Country,
    val CountryID: Int,
    val Distance: Double,
    val DistanceUnit: Int,
    val ID: Int,
    val Latitude: Double,
    val Longitude: Double,
    val Postcode: String,
    val RelatedURL: Any,
    val StateOrProvince: Any,
    val Title: String,
    val Town: String
)