package com.xmo.list.spotslist.model

/**
 * Model view to display on the screen [SpotsListFragment].
 */

data class SpotsList(
    val id: Int,
    val distance: Double,
    val numberOfPoints: Int,
    val town: String,
    val addressTitle: String,
    val websiteUrl: String,
    val generalComments: String
)