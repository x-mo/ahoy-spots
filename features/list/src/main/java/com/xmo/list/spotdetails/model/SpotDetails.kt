package com.xmo.list.spotdetails.model

/**
 * Model view to display on the screen [SpotDetailsFragment].
 */

data class SpotDetails(
    val id: Int,
    val distance: Double?,
    val numberOfPoints: Int?,
    val town: String?,
    val addressTitle: String?,
    val websiteUrl: String?,
    val generalComments: String?
)