package com.xmo.list.spotslist.di

import com.xmo.core.di.CoreComponent
import com.xmo.core.di.scopes.FeatureScope
import com.xmo.list.spotslist.SpotsListFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [SpotsListModule::class],
    dependencies = [CoreComponent::class]
)
interface SpotsListComponent {

    fun inject(detailFragment: SpotsListFragment)
}
