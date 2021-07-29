package com.xmo.home.di

import androidx.annotation.VisibleForTesting
import androidx.annotation.VisibleForTesting.PRIVATE

import com.xmo.home.HomeFragment
import com.xmo.home.HomeViewModel
import com.xmo.core.di.scopes.FeatureScope
import dagger.Module
import dagger.Provides
import com.xmo.core.extensions.*


@Module
class HomeModule(
    @VisibleForTesting(otherwise = PRIVATE)
    val fragment: HomeFragment
) {
    @Provides
    @FeatureScope
    fun providesHomeViewModel() = fragment.viewModel {
        HomeViewModel()
    }
}
