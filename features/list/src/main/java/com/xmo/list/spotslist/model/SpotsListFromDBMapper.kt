package com.xmo.list.spotslist.model

import com.xmo.core.database.spots.Spot
import com.xmo.core.mapper.Mapper
import com.xmo.core.network.responses.SpotsResponse

/**
 * Helper class to transforms network response to visual model, catching the necessary data.
 *
 * @see Mapper
 */
class SpotsListFromDBMapper : Mapper<List<Spot>, List<SpotsItem>> {

    override suspend fun map(from: List<Spot>) =
        from.toList().map {
            SpotsItem(
                id = it.id,
                distance = it.distance,
                numberOfPoints = it.numberOfPoints,
                town = it.town,
                addressTitle = it.addressTitle,
                websiteUrl = it.websiteUrl,
                generalComments = it.generalComments
            )
        }

}