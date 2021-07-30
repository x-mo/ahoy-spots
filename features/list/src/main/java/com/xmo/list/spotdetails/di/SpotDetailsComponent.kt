package com.xmo.list.spotdetails.di

import com.xmo.core.di.CoreComponent
import com.xmo.core.di.scopes.FeatureScope
import com.xmo.list.spotdetails.SpotDetailsFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [SpotDetailsModule::class],
    dependencies = [CoreComponent::class]
)
interface SpotDetailsComponent {

    fun inject(detailFragment: SpotDetailsFragment)
}
