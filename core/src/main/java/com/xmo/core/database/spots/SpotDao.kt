package com.xmo.core.database.spots

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SpotDao {


    @Query("SELECT * FROM spots ORDER BY distance")
    fun getAllSpotsLiveData(): LiveData<List<Spot>>

    @Query("SELECT * FROM spots ORDER BY distance")
    suspend fun getAllSpots(): List<Spot>

    @Query("SELECT * FROM spots WHERE id = :spotId")
    suspend fun getSpot(spotId: Int): Spot?

    @Query("DELETE FROM spots")
    suspend fun deleteAllSpots()

    @Query("DELETE FROM spots WHERE id = :spotId")
    suspend fun deleteSpotById(spotId: Int)


    @Delete
    suspend fun deleteSpot(spot: Spot)


    @Insert
    suspend fun insertSpots(spots: List<Spot>)


    @Insert
    suspend fun insertSpot(spot: Spot)
}
