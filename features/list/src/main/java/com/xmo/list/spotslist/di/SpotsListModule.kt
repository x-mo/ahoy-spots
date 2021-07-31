package com.xmo.list.spotslist.di

import android.widget.ProgressBar
import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import com.xmo.core.database.spots.SpotRepository
import com.xmo.core.di.scopes.FeatureScope
import com.xmo.core.extensions.viewModel
import com.xmo.core.network.repositiories.OCMRepository
import com.xmo.list.spotslist.SpotsListFragment
import com.xmo.list.spotslist.SpotsListViewModel
import com.xmo.list.spotslist.model.SpotsListFromDBMapper
import com.xmo.list.spotslist.model.SpotsListMapper
import com.xmo.list.spotslist.model.SpotsListToDBMapper
import dagger.Module
import dagger.Provides

@Module
class SpotsListModule(
    @VisibleForTesting(otherwise = PRIVATE)
    val fragment: SpotsListFragment
) {

    @FeatureScope
    @Provides
    fun providesSpotsListViewModel(
        ocmRepository: OCMRepository,
        spotRepository: SpotRepository,
        spotsListFromDBMapper: SpotsListFromDBMapper,
        spotsListToDBMapper: SpotsListToDBMapper
    ) = fragment.viewModel {
        SpotsListViewModel(
            ocmRepository = ocmRepository,
            spotRepository = spotRepository,
            spotsListFromDBMapper = spotsListFromDBMapper,
            spotsListToDBMapper = spotsListToDBMapper
        )
    }

    @FeatureScope
    @Provides
    fun providesProgressBarDialog() = ProgressBar(fragment.requireContext())

    @FeatureScope
    @Provides
    fun providesSpotsListFromDBMapper() = SpotsListFromDBMapper()

    @FeatureScope
    @Provides
    fun providesSpotsListToDBMapper() = SpotsListToDBMapper()
}
