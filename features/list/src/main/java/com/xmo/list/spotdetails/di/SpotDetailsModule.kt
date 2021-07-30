package com.xmo.list.spotdetails.di

import android.widget.ProgressBar
import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import com.xmo.list.spotdetails.SpotDetailsViewModel
import com.xmo.core.di.scopes.FeatureScope
import com.xmo.core.network.repositiories.OCMRepository
import com.xmo.list.spotdetails.SpotDetailsFragment
import com.xmo.list.spotdetails.model.SpotDetailsMapper
import dagger.Module
import dagger.Provides
import com.xmo.core.extensions.*

@Module
class SpotDetailsModule(
    @VisibleForTesting(otherwise = PRIVATE)
    val fragment: SpotDetailsFragment
) {

    @FeatureScope
    @Provides
    fun providesSpotDetailsViewModel(
        ocmRepository: OCMRepository,
        spotDetailsMapper: SpotDetailsMapper
    ) = fragment.viewModel {
        SpotDetailsViewModel(
            ocmRepository = ocmRepository,
            spotDetailsMapper = spotDetailsMapper
        )
    }

    @FeatureScope
    @Provides
    fun providesSpotDetailsMapper() = SpotDetailsMapper()

    @FeatureScope
    @Provides
    fun providesProgressBarDialog() = ProgressBar(fragment.requireContext())
}
