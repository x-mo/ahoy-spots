package com.xmo.core.database.spots

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spots")
data class Spot(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "town") val town: String,
    @ColumnInfo(name = "address_title") val addressTitle: String,
    @ColumnInfo(name = "website_url") val websiteUrl: String,
    @ColumnInfo(name = "number_of_points") val numberOfPoints: Int,
    @ColumnInfo(name = "general_comments") val generalComments: String,
    @ColumnInfo(name = "distance") val distance: Double
)