package com.xmo.list.spotslist.model

import com.xmo.core.mapper.Mapper
import com.xmo.core.network.responses.SpotsResponse

/**
 * Helper class to transforms network response to visual model, catching the necessary data.
 *
 * @see Mapper
 */
class SpotsListMapper : Mapper<SpotsResponse, SpotsList> {

    /**
     * Transform network response to [SpotsList].
     *
     * @param from Network spots response.
     * @return List of parsed spots items.
     * @throws NoSuchElementException If the response results are empty.
     */
    @Throws(NoSuchElementException::class)
    override suspend fun map(from: SpotsResponse): SpotsList {
        val spotResponse = from.first()
        return SpotsList(
            id = spotResponse.ID,
            distance = spotResponse.AddressInfo.Distance,
            numberOfPoints = spotResponse.NumberOfPoints,
            town = spotResponse.AddressInfo.Town,
            addressTitle = spotResponse.AddressInfo.Title,
            websiteUrl = spotResponse.DataProvider.WebsiteURL,
            generalComments = spotResponse.GeneralComments
        )
    }
}