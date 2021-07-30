package com.xmo.list.spotslist.model

import com.xmo.core.mapper.Mapper
import com.xmo.core.network.responses.SpotsResponse

/**
 * Helper class to transforms network response to visual model, catching the necessary data.
 *
 * @see Mapper
 */
class SpotsListMapper : Mapper<SpotsResponse, List<SpotsItem>> {

    override suspend fun map(from: SpotsResponse) =
        from.toList().map {
            SpotsItem(
                id = it.ID,
                distance = it.AddressInfo.Distance,
                numberOfPoints = it.NumberOfPoints,
                town = it.AddressInfo.Town,
                addressTitle = it.AddressInfo.Title,
                websiteUrl = it.DataProvider.WebsiteURL,
                generalComments = it.GeneralComments
            )
        }

}