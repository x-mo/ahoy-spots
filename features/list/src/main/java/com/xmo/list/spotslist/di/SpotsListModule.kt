package com.xmo.list.spotslist.di

import android.widget.ProgressBar
import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE
import com.xmo.core.di.scopes.FeatureScope
import com.xmo.core.extensions.viewModel
import com.xmo.core.network.repositiories.OCMRepository
import com.xmo.list.spotslist.SpotsListFragment
import com.xmo.list.spotslist.SpotsListViewModel
import com.xmo.list.spotslist.model.SpotsListMapper
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
        spotsListMapper: SpotsListMapper
    ) = fragment.viewModel {
        SpotsListViewModel(
            ocmRepository = ocmRepository,
            spotsListMapper = spotsListMapper
        )
    }

    @FeatureScope
    @Provides
    fun providesSpotsListMapper() = SpotsListMapper()

    @FeatureScope
    @Provides
    fun providesProgressBarDialog() = ProgressBar(fragment.requireContext())
}
