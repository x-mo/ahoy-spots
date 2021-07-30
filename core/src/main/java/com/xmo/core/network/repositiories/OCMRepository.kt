package com.xmo.core.network.repositiories

import com.xmo.core.BuildConfig
import com.xmo.core.network.responses.SpotsResponse
import com.xmo.core.network.services.OCMService

private const val API_KEY = BuildConfig.OCM_KEY

class OCMRepository(
    private val service: OCMService
) {

    suspend fun getSpot(id: Int): SpotsResponse {
        return service.getSpot(
            id = id,
            apiKey = API_KEY,
        )

    }
    //    ArrayList<SpotsResponse>
    suspend fun getSpots(lat: Double, lng: Double): SpotsResponse {
        return service.getSpots(
            apiKey = API_KEY,
            outputFormat = "JSON",
            maxResults = 40,
            latitude = lat,
            longitude = lng
        )
    }
}