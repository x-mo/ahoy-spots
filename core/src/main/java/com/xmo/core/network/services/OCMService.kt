package com.xmo.core.network.services

import com.xmo.core.network.responses.SpotsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OCMService {

    @GET("/v3/poi")
    suspend fun getSpot(
        @Query("id") id: Int,
        @Query("key") apiKey: String,
        @Query("distanceunit") unit: String,
    ): SpotsResponse


    ///v3/poi/?output=json&countrycode=AE&maxresults=5&latitude=25.204849&longitude=55.270782
    @GET("/v3/poi")
    suspend fun getSpots(
        @Query("key") apiKey: String,
        @Query("output") outputFormat: String,
        @Query("maxresults") maxResults: Int,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("distanceunit") unit: String,
    ): SpotsResponse
}
