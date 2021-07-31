package com.xmo.core.database.spots

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import androidx.lifecycle.LiveData
import com.xmo.core.database.spots.Spot
import com.xmo.core.database.spots.SpotDao
import javax.inject.Inject

class SpotRepository @Inject constructor(
    @VisibleForTesting(otherwise = PRIVATE)
    internal val spotDao: SpotDao
) {


    fun getAllSpotsLiveData(): LiveData<List<Spot>> =
        spotDao.getAllSpotsLiveData()

    suspend fun getAllSpots(): List<Spot> =
        spotDao.getAllSpots()

    suspend fun getSpot(spotId: Int): Spot? =
        spotDao.getSpot(spotId)

    suspend fun deleteAllSpots() =
        spotDao.deleteAllSpots()

    suspend fun deleteSpotById(SpotId: Int) =
        spotDao.deleteSpotById(SpotId)

    suspend fun deleteSpot(spot: Spot) =
        spotDao.deleteSpot(spot)

    suspend fun insertSpots(spots: List<Spot>) =
        spotDao.insertSpots(spots)

    suspend fun insertSpot(
        id: Int,
        town: String,
        addressTitle: String,
        websiteUrl: String,
        numberOfPoints: Int,
        generalComments: String,
        distance: Double
    ) {
        val spot = Spot(
            id = id,
            town = town,
            addressTitle = addressTitle,
            websiteUrl = websiteUrl,
            numberOfPoints = numberOfPoints,
            generalComments = generalComments,
            distance = distance
        )
        spotDao.insertSpot(spot)
    }

}
